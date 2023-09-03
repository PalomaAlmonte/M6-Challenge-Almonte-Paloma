package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository custRepo;

    @BeforeEach
    public void setUp() throws Exception{
        custRepo.deleteAll();
    }

    @Test
    public void createCustomer(){

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

        customer = custRepo.save(customer);

        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);
    }

    @Test
    public void getCustomersByState() {

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

        customer = custRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Paloma");
        customer2.setLastName("Ortiz");
        customer2.setAddressOne("1111 times square street NY 10290" );
        customer2.setAddressTwo("2891 rose park ave. NY 18300");
        customer2.setCustomerEmail("POrtiz@gmail.com");
        customer2.setCompany("Netflix");
        customer2.setCity("Weehawken" );
        customer2.setState("NY");
        customer2.setCountry("US");
        customer2.setPostalCode("129003");
        //Act
        customer2 = custRepo.save(customer2);

        List<Customer> customerList = custRepo.findByState(customer.getState());
        assertEquals(2,customerList.size());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();

        customer.setFirstName("rose");
        customer.setLastName("smith");
        customer.setAddressOne("56 lolo street NY 9021" );
        customer.setAddressTwo("2891 rose ave. NY 18300");
        customer.setCustomerEmail("rsmit@gmail.com");
        customer.setCompany("walmart");
        customer.setCity("Manhattan" );
        customer.setState("NY");
        customer.setCountry("US");
        customer.setPostalCode("129003");

        customer = custRepo.save(customer);

        customer.setFirstName("UPDATED");

        custRepo.save(customer);

        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);
    }


    @Test
    public void deleteCustomer(){
        Customer customer = new Customer();

        customer.setFirstName("rose");
        customer.setLastName("smith");
        customer.setAddressOne("56 lolo street NY 9021" );
        customer.setAddressTwo("2891 rose ave. NY 18300");
        customer.setCustomerEmail("rsmit@gmail.com");
        customer.setCompany("walmart");
        customer.setCity("Manhattan" );
        customer.setState("NY");
        customer.setCountry("US");
        customer.setPostalCode("129003");

        customer = custRepo.save(customer);

        custRepo.deleteById(customer.getCustomerId());

        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }
}