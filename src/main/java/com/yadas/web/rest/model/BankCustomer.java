package com.yadas.web.rest.model;

import javax.persistence.*;

@Entity
@Table(name="bank_customer")
public class BankCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String customerId;
    private String customerName;

    public BankCustomer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }


}
