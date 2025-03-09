package com.banking.repositories.abstracts;

import com.banking.entities.CorporateCustomer;

public interface CorporateCustomerRepository extends BaseRepository<CorporateCustomer, Long> {
    boolean existsByTaxNumber(String taxNumber);
    boolean existsByTradeRegisterNumber(String tradeRegisterNumber);
    CorporateCustomer findByTaxNumber(String taxNumber);
} 