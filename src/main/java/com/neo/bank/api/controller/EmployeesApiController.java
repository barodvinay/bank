package com.neo.bank.api.controller;

import com.neo.bank.api.EmployeesApi;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.model.CreateAccountResponse;
import com.neo.bank.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class EmployeesApiController implements EmployeesApi {
    private final EmployeeService employeeService;
    @Override
    public ResponseEntity<CreateAccountResponse> employeeAccountCreate(String employeeId, CreateAccountRequest createAccountRequest) {
        return status(OK).body(employeeService.createAccount(createAccountRequest));
    }
}
