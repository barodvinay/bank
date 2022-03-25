package com.neo.bank.api.mapper;

import com.neo.bank.api.exception.BankException;
import com.neo.bank.api.model.RestError;
import org.springframework.stereotype.Component;

@Component
public class RestErrorMapper {
    public RestError mapBankException(BankException ex) {
        return new RestError().builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
    }
}
