package com.banking.business.rules;

import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public void checkIfEmailExists(String email) {
        if (customerRepository.existsByEmail(email)) {
            throw new BusinessException("Email already exists", "EMAIL_EXISTS");
        }
    }

    public void checkIfCustomerNumberExists(String customerNumber) {
        if (customerRepository.existsByCustomerNumber(customerNumber)) {
            throw new BusinessException("Customer number already exists", "CUSTOMER_NUMBER_EXISTS");
        }
    }
} 