package com.neo.bank.api.service;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.mapper.BalanceDetailsDataMapper;
import com.neo.bank.api.mapper.ResponseMetaMapper;
import com.neo.bank.api.model.BalanceDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.neo.bank.api.constant.BankConstant.BALANCE_DETAIL_CODE;
import static com.neo.bank.api.constant.BankConstant.BALANCE_DETAIL_MESSAGE;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerClientService customerClientService;
    private final BalanceDetailsDataMapper balanceDetailsDataMapper;
    private final ResponseMetaMapper responseMetaMapper;
    public BalanceDetails getBalance(String customerId) {
        Customer customer=customerClientService.getCustomer(customerId);
        return BalanceDetails.builder()
                .meta(responseMetaMapper.mapResponseMeta(BALANCE_DETAIL_CODE,BALANCE_DETAIL_MESSAGE))
                .data(balanceDetailsDataMapper.mapBalanceDetail(customer))
                .build();
    }
}
