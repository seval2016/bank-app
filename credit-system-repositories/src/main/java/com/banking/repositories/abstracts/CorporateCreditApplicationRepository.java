package com.banking.repositories.abstracts;

import com.banking.entities.CorporateCreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCreditApplicationRepository extends JpaRepository<CorporateCreditApplication, Long> {
    CorporateCreditApplication findByApplicationNumber(String applicationNumber);
} 