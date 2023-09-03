package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
//JPA Relational DataB
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String customerEmail;
    private String company;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    //Getters & setters
    public Integer getCustomerId() {

        return customerId;
    }

    public void setCustomerId(Integer customerId) {

        this.customerId = customerId;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerEmail() {

        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddressOne() {

        return addressOne;
    }

    public void setAddressOne(String addressOne) {

        this.addressOne = addressOne;
    }

    public String getAddressTwo() {

        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {

        this.addressTwo = addressTwo;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId) && firstName.equals(customer.firstName)
                && lastName.equals(customer.lastName) && customerEmail.equals(customer.customerEmail)
                && company.equals(customer.company) && addressOne.equals(customer.addressOne)
                && addressTwo.equals(customer.addressTwo) && city.equals(customer.city) && state.equals(customer.state)
                && postalCode.equals(customer.postalCode) && country.equals(customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, customerEmail, company, addressOne, addressTwo, city,
                state, postalCode, country);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", company='" + company + '\'' +
                ", addressOne='" + addressOne + '\'' +
                ", addressTwo='" + addressTwo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
