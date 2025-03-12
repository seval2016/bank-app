package com.banking.repositories.abstracts;

import com.banking.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
    boolean existsByNationalIdentity(String nationalIdentity);
    boolean existsByCustomerNumber(String customerNumber);
    IndividualCustomer findByNationalIdentity(String nationalIdentity);
    IndividualCustomer findByCustomerNumber(String customerNumber);
    @Query("SELECT ic FROM IndividualCustomer ic WHERE ic.user.email = :email")
    Optional<IndividualCustomer> findByEmail(@Param("email") String email);
} 