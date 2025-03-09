package com.banking.repositories.abstracts;

import com.banking.entities.IndividualCreditApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCreditApplicationRepository extends JpaRepository<IndividualCreditApplication, Long> {
    IndividualCreditApplication findByApplicationNumber(String applicationNumber);
    Page<IndividualCreditApplication> findByCustomerId(Long customerId, Pageable pageable);
} 