package com.neo.bank.api.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="CUSTOMER_ID")
    private String customerId;

    @Column(name="AVAILABLE_BALANCE")
    private BigDecimal availableBalance;
}
