package com.neo.bank.api.service;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.mapper.CustomerMapper;
import com.neo.bank.api.mapper.ResponseMetaMapper;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.neo.bank.api.constant.BankConstant.ACCOUNT_CREATE_SUCCESS_CODE;
import static com.neo.bank.api.constant.BankConstant.ACCOUNT_CREATE_SUCCESS_MESSAGE;

@Service
@RequiredArgsConstructor
public class EmployeeCustomerService {
    private final CustomerService customerService;
    private final ResponseMetaMapper responseMetaMapper;
    private final CustomerMapper customerMapper;
    private final BankEmployeeService bankEmployeeService;

    public CreateAccountResponse createAccount(String employeeId,CreateAccountRequest createAccountRequest) {
        verifyEmployee(employeeId);
        Customer customer =   customerMapper.mapCreateAccountRequest(createAccountRequest);
        return  CreateAccountResponse.builder()
                .meta(responseMetaMapper.mapResponseMeta(ACCOUNT_CREATE_SUCCESS_CODE,ACCOUNT_CREATE_SUCCESS_MESSAGE))
                .data(customerMapper.mapCreateAccountResponse(customerService.createCustomer(customer)))
                .build();
    }

    private void verifyEmployee(String employeeId) {
        bankEmployeeService.getEmployee(employeeId);
    }

}
