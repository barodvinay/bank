package com.neo.bank.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="CUSTOMER_ID")
    private Customer customer;

    @Column(name="TRANSACTION_DATE_TIME")
    private LocalDateTime transactionDateTime;

    @Column(name="Status")
    private String status;

    @Column(name="Amount")
    private BigDecimal amount;
}
