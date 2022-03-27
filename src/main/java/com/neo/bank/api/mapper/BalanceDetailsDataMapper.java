package com.neo.bank.api.mapper;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.model.BalanceDetailsData;
import org.springframework.stereotype.Component;

@Component
public class BalanceDetailsDataMapper {
    public BalanceDetailsData mapBalanceDetail(Customer customer) {
        return BalanceDetailsData.builder()
                .customerId(customer.getCustomerId())
                .availableBalance(customer.getAvailableBalance().toString())
                .build();
    }
}
