package com.neo.bank.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class BankException extends RuntimeException{
    private String code;
    private String message;
    private HttpStatus status;


}
