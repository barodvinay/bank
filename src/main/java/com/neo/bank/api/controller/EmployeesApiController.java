package com.neo.bank.api.controller;

import com.neo.bank.api.EmployeesApi;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import org.springframework.http.ResponseEntity;

public class EmployeesApiController implements EmployeesApi {
    @Override
    public ResponseEntity<CreateAccountResponse> employeeAccountCreate(String employeeId, CreateAccountRequest createAccountRequest) {
        return null;
    }
}
