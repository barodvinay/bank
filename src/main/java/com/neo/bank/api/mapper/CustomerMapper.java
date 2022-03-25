package com.neo.bank.api.mapper;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.model.CreateAccountData;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer mapCreateAccountRequest(CreateAccountRequest createAccountRequest) {
        Customer customer=new Customer();
        customer.setAvailableBalance(BigDecimal.valueOf(createAccountRequest.getOpeningBalance()));
        customer.setCustomerId(generateCustomerId());
        return customer;
    }

    private String generateCustomerId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        return "CUST"+ LocalDateTime.now().format(formatter);
    }

    public CreateAccountData mapCreateAccountResponse(Customer customer) {
        return CreateAccountData.builder()
                .customerId(customer.getCustomerId())
                .build();
    }
}
