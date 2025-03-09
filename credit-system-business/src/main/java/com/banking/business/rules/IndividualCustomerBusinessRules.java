package com.banking.business.rules;

import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CustomerRepository;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import com.banking.business.constants.Messages;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class IndividualCustomerBusinessRules extends BaseCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;

    public IndividualCustomerBusinessRules(
            CustomerRepository customerRepository,
            IndividualCustomerRepository individualCustomerRepository) {
        super(customerRepository);
        this.individualCustomerRepository = individualCustomerRepository;
    }

    public void checkIfNationalIdentityExists(String nationalIdentity) {
        if (individualCustomerRepository.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Customer.NATIONAL_IDENTITY_ALREADY_EXISTS, "NATIONAL_IDENTITY_EXISTS");
        }
    }
} 