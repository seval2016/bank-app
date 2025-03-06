package com.banking.repositories.abstracts;

import com.banking.entities.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    boolean existsByCustomerNumber(String customerNumber);
    Customer findByCustomerNumber(String customerNumber);
}