package com.banking.business.rules;

import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CustomerRepository;
import com.banking.business.constants.Messages;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseCustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public void checkIfEmailExists(String email) {
        if (customerRepository.existsByEmail(email)) {
            throw new BusinessException(Messages.Customer.EMAIL_ALREADY_EXISTS, "EMAIL_EXISTS");
        }
    }

    public void checkIfCustomerNumberExists(String customerNumber) {
        if (customerRepository.existsByCustomerNumber(customerNumber)) {
            throw new BusinessException(Messages.Customer.CUSTOMER_NUMBER_ALREADY_EXISTS, "CUSTOMER_NUMBER_EXISTS");
        }
    }
} 