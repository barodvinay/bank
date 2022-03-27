package com.neo.bank.api.service;

import com.neo.bank.api.entity.Customer;
import com.neo.bank.api.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerClientServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerClientService customerClientService;

    @Test
    public void whenCreateCustomerIsCalledThenExpectCustomerCreation(){
        Customer customer=new Customer();
        customer.setCustomerId("C001");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer result=customerClientService.createCustomer(customer);
        assertThat(result).isNotNull();
        verify(customerRepository).save(customer);
    }

}
