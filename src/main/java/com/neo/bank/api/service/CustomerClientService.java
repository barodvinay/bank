package com.neo.bank.api.service;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.exception.BankException;
import com.neo.bank.api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.neo.bank.api.constant.BankConstant.INVALID_CUSTOMER_CODE;
import static com.neo.bank.api.constant.BankConstant.INVALID_CUSTOMER_MESSAGE;

@Service
@RequiredArgsConstructor
public class CustomerClientService {
    private final CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(String customerId) {
        return customerRepository.findByCustomerId(customerId).
                orElseThrow(()-> new BankException(INVALID_CUSTOMER_CODE,INVALID_CUSTOMER_MESSAGE, HttpStatus.NOT_FOUND));
    }
}
