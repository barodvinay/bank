package com.neo.bank.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.bank.api.model.CreateAccountRequest;
import com.neo.bank.api.service.EmployeeCustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeesApiController.class, useDefaultFilters = false)
public class EmployeeControllerTest {
    public static final String EMPLOYEE_BASE_URL = "/employees";
    public static final String CREATE_ACCOUNT_BASE_URL = "/create-account";
    public static final String EMPLOYEE_ID_HEADER="employeeId";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeCustomerService employeeCustomerService;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setMockMvc() {
        this.mockMvc = standaloneSetup(new EmployeesApiController(employeeCustomerService))
                .build();
    }

    @Test
    @DisplayName("Create account api")
    void whenPostCreateAccountIsCalledWithValidRequestThenExpectValidResponse() throws Exception {
        String employeeId = "1";

        mockMvc.perform(post(EMPLOYEE_BASE_URL + CREATE_ACCOUNT_BASE_URL)
                        .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                        .header(EMPLOYEE_ID_HEADER, employeeId)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(this .mapper.writeValueAsString(createAccountRequest())))
                .andExpect(status().isOk());

        verify(employeeCustomerService).createAccount(employeeId,createAccountRequest());
    }



    private CreateAccountRequest createAccountRequest() {
        return CreateAccountRequest.builder().build();
    }
}
