package com.yadas.web.rest.controller;

import com.yadas.web.rest.model.Customer;
import com.yadas.web.rest.model.Order;
import com.yadas.web.rest.service.CustomerService;
import com.yadas.web.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        return customerService.getCustomerDetail(customerId);
    }

    @GetMapping(value = "/{customerId}/orders", produces = { "application/hal+json" })
    public CollectionModel<Order> getOrdersForCustomer(@PathVariable final String customerId) {
        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        for (final Order order : orders) {
            Link selfLink = linkTo(methodOn(CustomerController.class).getOrderById(customerId, order.getOrderId())).withSelfRel();
            order.add(selfLink);
        }

        Link link = linkTo(methodOn(CustomerController.class).getOrdersForCustomer(customerId)).withSelfRel();
        CollectionModel<Order> result = CollectionModel.of(orders, link);
        return result;
    }

    @GetMapping(produces = { "application/hal+json" })
    public CollectionModel<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.allCustomers();

        for (Customer customer : allCustomers) {
            String customerId = customer.getCustomerId();
            Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
            customer.add(selfLink);
            if (orderService.getAllOrdersForCustomer(customerId).size() > 0) {
                Link ordersLink = linkTo(methodOn(CustomerController.class)
                        .getOrdersForCustomer(customerId)).withRel("allOrders");
                customer.add(ordersLink);
            }
        }

        Link link = linkTo(CustomerController.class).withSelfRel();
        CollectionModel<Customer> result = CollectionModel.of(allCustomers, link);
        return result;
    }

    public Order getOrderById(String customerId, String orderId){
        Map<String, Order> map = new HashMap<>();
        Order o1 = new Order();
        o1.setOrderId("01");
        o1.setQuantity(10);
        o1.setPrice(100.10);
        Order o2 = new Order();
        o2.setOrderId("02");
        o2.setQuantity(20);
        o2.setPrice(200.20);
        Order o3 = new Order();
        o3.setOrderId("03");
        o3.setQuantity(30);
        o3.setPrice(300.30);
        map.put(o1.getOrderId(), o1);
        map.put(o2.getOrderId(), o2);
        map.put(o3.getOrderId(), o3);
        return map.get(orderId);
    }
}
