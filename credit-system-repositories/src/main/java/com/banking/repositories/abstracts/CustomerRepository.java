package com.banking.repositories.abstracts;

import com.banking.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends BaseRepository<Customer, Long> {
    @Query("SELECT COUNT(c) > 0 FROM Customer c WHERE c.user.email = :email")
    boolean existsByEmail(@Param("email") String email);
    
    boolean existsByCustomerNumber(String customerNumber);
    Customer findByCustomerNumber(String customerNumber);
}