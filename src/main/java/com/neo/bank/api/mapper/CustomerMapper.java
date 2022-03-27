package com.neo.bank.api.mapper;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.model.CreateAccountData;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import com.neo.bank.api.model.UpdateAccountRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

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

    public Customer mapUpdateAccountRequest(Customer customer,UpdateAccountRequest updateAccountRequest) {
        BigDecimal addBalance=nonNull(updateAccountRequest.getAddFund())?new BigDecimal(updateAccountRequest.getAddFund()):BigDecimal.ZERO;
        customer.setAvailableBalance(customer.getAvailableBalance().add(addBalance));
        return customer;
    }
}
