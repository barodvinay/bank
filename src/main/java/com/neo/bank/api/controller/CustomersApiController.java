package com.neo.bank.api.controller;


import com.neo.bank.api.CustomersApi;
import com.neo.bank.api.model.AccountSummary;
import com.neo.bank.api.model.BalanceDetails;
import com.neo.bank.api.model.FundTransferRequest;
import com.neo.bank.api.model.FundTransferResponse;
import com.neo.bank.api.model.PayeeRequest;
import com.neo.bank.api.model.PayeeResponse;
import com.neo.bank.api.service.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class CustomersApiController implements CustomersApi {

    private CustomerService customerService;

    @Override
    public ResponseEntity<FundTransferResponse> customerFundTransfer(String customerId, FundTransferRequest fundTransferRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<PayeeResponse>> customersAddPayee(String customerId, PayeeRequest payeeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<AccountSummary> customersGetAccountSummary(String customerId) {
        return null;
    }

    @Override
    public ResponseEntity<BalanceDetails> customersGetBalance(String customerId) {
        return status(OK).body(customerService.getBalance(customerId));
    }

    @Override
    public ResponseEntity<List<PayeeResponse>> customersGetPayees(String customerId) {
        return null;
    }
}
