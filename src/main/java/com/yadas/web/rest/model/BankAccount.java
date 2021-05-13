package com.yadas.web.rest.model;

import javax.persistence.*;

@Entity
@Table(name="bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private String customerId;
    private String branchCode;

    public BankAccount(Long accountNumber, String customerId, String branchCode) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.branchCode = branchCode;
    }
}
