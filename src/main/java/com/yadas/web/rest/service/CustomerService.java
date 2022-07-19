package com.yadas.web.rest.service;

import com.yadas.web.rest.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer getCustomerDetail(String customerId){
        Customer c1 = new Customer();
        c1.setCustomerId("c1");
        c1.setCustomerName("Saurabh Yadav");
        c1.setCompanyName("Pegasystem Inc.");
        return c1;
    }

    public List<Customer> allCustomers(){
        Customer c1 = new Customer();
        c1.setCustomerId("c1");
        c1.setCustomerName("Saurabh Yadav");
        c1.setCompanyName("Pegasystem Inc.");
        return List.of(c1);
    }
}
