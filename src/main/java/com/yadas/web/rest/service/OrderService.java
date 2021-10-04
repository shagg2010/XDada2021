package com.yadas.web.rest.service;

import com.yadas.web.rest.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public List<Order> getAllOrdersForCustomer(String customerId){
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

        List<Order> orderList = List.of(o1, o2, o3);
        return orderList;
    }

}
