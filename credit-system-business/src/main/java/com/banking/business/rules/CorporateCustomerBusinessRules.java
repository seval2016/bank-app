package com.banking.business.rules;

import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.repositories.abstracts.CustomerRepository;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import com.banking.business.constants.Messages;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CorporateCustomerBusinessRules extends BaseCustomerBusinessRules {
    private final CorporateCustomerRepository corporateCustomerRepository;

    public CorporateCustomerBusinessRules(
            CustomerRepository customerRepository,
            CorporateCustomerRepository corporateCustomerRepository) {
        super(customerRepository);
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.Customer.TAX_NUMBER_ALREADY_EXISTS, "TAX_NUMBER_EXISTS");
        }
    }

    public void checkIfTradeRegisterNumberExists(String tradeRegisterNumber) {
        if (corporateCustomerRepository.existsByTradeRegisterNumber(tradeRegisterNumber)) {
            throw new BusinessException(Messages.Customer.TRADE_REGISTER_NUMBER_ALREADY_EXISTS, "TRADE_REGISTER_NUMBER_EXISTS");
        }
    }
} 