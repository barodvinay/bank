package com.neo.bank.api.service;

import com.neo.bank.api.entity.BankEmployee;
import com.neo.bank.api.exception.BankException;
import com.neo.bank.api.repository.BankEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.neo.bank.api.constant.BankConstant.INVALID_EMPLOYEE_MESSAGE;
import static com.neo.bank.api.constant.BankConstant.INVALID_EMPLOYEE_CODE;

@Service
@RequiredArgsConstructor
public class BankEmployeeClientService {
    private final BankEmployeeRepository bankEmployeeRepository;

    public BankEmployee getEmployee(String employeeId) {
        return bankEmployeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(()-> new BankException( INVALID_EMPLOYEE_CODE,INVALID_EMPLOYEE_MESSAGE, HttpStatus.UNAUTHORIZED));
    }
}
