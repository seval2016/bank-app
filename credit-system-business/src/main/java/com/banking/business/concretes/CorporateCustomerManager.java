package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCustomerService;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.business.mappings.CorporateCustomerMapper;
import com.banking.business.rules.CustomerBusinessRules;
import com.banking.entities.CorporateCustomer;
import com.banking.entities.Customer;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.banking.business.constants.Messages;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final CustomerBusinessRules rules;
    private final CorporateCustomerMapper mapper;

    @Override
    public CorporateCustomerResponse add(CreateCorporateCustomerRequest request) {
        // İş kuralı kontrolleri
        rules.checkIfEmailExists(request.getEmail());
        checkIfTaxNumberExists(request.getTaxNumber());
        checkIfTradeRegisterNumberExists(request.getTradeRegisterNumber());
        
        // Yeni kurumsal müşteri oluşturma
        CorporateCustomer customer = mapper.toEntity(request);
        customer.setCustomerNumber(UUID.randomUUID().toString());
        
        // Kaydetme ve response dönüşü
        corporateCustomerRepository.save(customer);
        return mapper.toResponse(customer);
    }

    @Override
    public List<CorporateCustomerResponse> getAllCorporates() {
        return corporateCustomerRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        return mapper.toResponse(
                corporateCustomerRepository.findByTaxNumber(taxNumber)
        );
    }

    @Override
    public List<Customer> getAllCustomers() {
        return corporateCustomerRepository.findAll().stream()
                .map(customer -> (Customer) customer)
                .toList();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return corporateCustomerRepository.findById(id).map(customer -> (Customer) customer);
    }

    @Override
    public Optional<Customer> getCustomerByNumber(String customerNumber) {
        return Optional.ofNullable(corporateCustomerRepository.findByCustomerNumber(customerNumber))
                .map(customer -> (Customer) customer);
    }

    @Override
    public void validateCustomerNumber(String customerNumber) {
        if (corporateCustomerRepository.existsByCustomerNumber(customerNumber)) {
            throw new RuntimeException(Messages.Customer.CUSTOMER_NUMBER_ALREADY_EXISTS);
        }
    }

    // Private yardımcı metodlar
    private void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new RuntimeException(Messages.Customer.TAX_NUMBER_ALREADY_EXISTS);
        }
    }

    private void checkIfTradeRegisterNumberExists(String tradeRegisterNumber) {
        if (corporateCustomerRepository.existsByTradeRegisterNumber(tradeRegisterNumber)) {
            throw new RuntimeException("Trade register number already exists");
        }
    }
} 