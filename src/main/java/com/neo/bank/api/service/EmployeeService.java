package com.neo.bank.api.service;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.mapper.CustomerMapper;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer=   customerMapper.mapCreateAccountRequest(createAccountRequest);
        customerService.createCustomer(customer);
        return null;
    }
}
