package com.neo.bank.api.exceptionHandler;

import com.neo.bank.api.exception.BankException;
import com.neo.bank.api.mapper.RestErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class BankExceptionHandler extends ResponseEntityExceptionHandler {
    private final RestErrorMapper restErrorMapper;
    @ExceptionHandler(value = BankException.class)
    public ResponseEntity<Object> handleException(BankException ex) {
        return new ResponseEntity<>(restErrorMapper.mapBankException(ex),ex.getStatus());
    }
}
