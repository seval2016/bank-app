package com.banking.repositories.abstracts;

import com.banking.entities.IndividualCustomer;

public interface IndividualCustomerRepository extends BaseRepository<IndividualCustomer, Long> {
    boolean existsByNationalIdentity(String nationalIdentity);
    IndividualCustomer findByNationalIdentity(String nationalIdentity);
} 