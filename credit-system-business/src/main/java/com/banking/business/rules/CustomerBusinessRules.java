package com.banking.business.rules;

import com.banking.business.constants.Messages;
import com.banking.repositories.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public void checkIfEmailExists(String email) {
        if (customerRepository.existsByEmail(email)) {
            throw new RuntimeException(Messages.Customer.EMAIL_ALREADY_EXISTS);
        }
    }

    public void checkIfCustomerNumberExists(String customerNumber) {
        if (customerRepository.existsByCustomerNumber(customerNumber)) {
            throw new RuntimeException(Messages.Customer.CUSTOMER_NUMBER_ALREADY_EXISTS);
        }
    }
} 