package com.banking.business.abstracts;

import com.banking.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Optional<Customer> getCustomerByNumber(String customerNumber);
    void validateCustomerNumber(String customerNumber);
} 