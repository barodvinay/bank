package com.neo.bank.api.controller;

import com.neo.bank.api.EmployeesApi;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import com.neo.bank.api.model.UpdateAccountRequest;
import com.neo.bank.api.model.UpdateAccountResponse;
import com.neo.bank.api.service.EmployeeCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class EmployeesApiController implements EmployeesApi {
    private final EmployeeCustomerService employeeCustomerService;
    @Override
    public ResponseEntity<CreateAccountResponse> employeeAccountCreate(String employeeId, CreateAccountRequest createAccountRequest) {
        return status(OK).body(employeeCustomerService.createAccount(employeeId,createAccountRequest));
    }

    @Override
    public ResponseEntity<UpdateAccountResponse> employeeAccountUpdate(String employeeId, UpdateAccountRequest updateAccountRequest) {
        return status(OK).body(employeeCustomerService.updateAccount(employeeId,updateAccountRequest));
    }
}
