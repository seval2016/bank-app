package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCustomerService;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.business.mappings.CorporateCustomerMapper;
import com.banking.business.rules.CustomerBusinessRules;
import com.banking.entities.CorporateCustomer;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.banking.business.constants.Messages;

import java.util.List;
import java.util.UUID;

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

    // CustomerService'den gelen metodların implementasyonu
    @Override
    public List<CustomerResponse> getAll() {
        return corporateCustomerRepository.findAll()
                .stream()
                .map(customer -> mapper.toResponse(customer))
                .map(response -> (CustomerResponse) response)
                .toList();
    }

    @Override
    public CustomerResponse getById(Long id) {
        return mapper.toResponse(
                corporateCustomerRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public void deleteById(Long id) {
        corporateCustomerRepository.deleteById(id);
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