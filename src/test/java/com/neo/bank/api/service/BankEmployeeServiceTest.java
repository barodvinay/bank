package com.neo.bank.api.service;

import com.neo.bank.api.entity.BankEmployee;
import com.neo.bank.api.repository.BankEmployeeRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankEmployeeServiceTest {
    @Mock
    private  BankEmployeeRepository bankEmployeeRepository;

    @InjectMocks
    private BankEmployeeService bankEmployeeService;

    @Test
    void whenGetEmployeeCalledWithValidIdThenExceptValidResult() {
        BankEmployee bankEmployee=new BankEmployee();
        when(bankEmployeeRepository.findByEmployeeId("1")).thenReturn(Optional.of(bankEmployee));
        BankEmployee result = bankEmployeeService.getEmployee("1");
        assertThat(result).isNotNull();
        verify(bankEmployeeRepository).findByEmployeeId(anyString());
    }
}
