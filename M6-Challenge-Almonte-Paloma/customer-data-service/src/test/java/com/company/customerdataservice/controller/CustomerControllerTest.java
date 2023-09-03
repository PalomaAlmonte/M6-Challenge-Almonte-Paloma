package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @MockBean
    private CustomerRepository repo;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void shouldGetCustomerById() throws Exception{
        mockMvc.perform(get("/customer/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldGetByState() throws Exception {
        mockMvc.perform(get("/customers/newYork"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customer/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldCreateCustomer() throws Exception{
        Customer customer = new Customer();

        customer.setFirstName("Paloma");
        customer.setLastName("Ortiz");
        customer.setAddressOne("1111 times square street NY 10290" );
        customer.setAddressTwo("2891 rose park ave. NY 18300");
        customer.setCustomerEmail("POrtiz@gmail.com");
        customer.setCompany("Netflix");
        customer.setCity("Weehawken" );
        customer.setState("NY");
        customer.setCountry("US");
        customer.setPostalCode("129003");

        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();

        customer.setFirstName("Paloma");
        customer.setLastName("Falk");
        customer.setAddressOne("341 times street NY 10290" );
        customer.setAddressTwo("2891 rose ave. NY 18300");
        customer.setCustomerEmail("PFalk@gmail.com");
        customer.setCompany("Netflix");
        customer.setCity("Manhattan" );
        customer.setState("NY");
        customer.setCountry("US");
        customer.setPostalCode("129003");

        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}