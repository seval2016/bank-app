package com.banking.repositories.abstracts;

import com.banking.entities.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long> {
    boolean existsByTaxNumber(String taxNumber);
    boolean existsByTradeRegisterNumber(String tradeRegisterNumber);
    boolean existsByCustomerNumber(String customerNumber);
    CorporateCustomer findByTaxNumber(String taxNumber);
    CorporateCustomer findByCustomerNumber(String customerNumber);
} 