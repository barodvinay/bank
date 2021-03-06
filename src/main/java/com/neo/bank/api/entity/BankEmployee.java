package com.neo.bank.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_EMPLOYEE")
public class BankEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="EMPLOYEE_ID")
    private String employeeId;

    @Column(name="EMPLOYEE_NAME")
    private String employeeName;
}
