package com.banking.business.concretes;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.business.mappings.IndividualCustomerMapper;
import com.banking.business.rules.CustomerBusinessRules;
import com.banking.entities.IndividualCustomer;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerBusinessRules rules;
    private final IndividualCustomerMapper mapper;

    @Override
    public IndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        rules.checkIfEmailExists(request.getEmail());
        rules.checkIfNationalIdentityExists(request.getNationalIdentity());
        
        IndividualCustomer customer = mapper.toEntity(request);
        customer.setCustomerNumber(UUID.randomUUID().toString());
        
        individualCustomerRepository.save(customer);
        return mapper.toResponse(customer);
    }

    @Override
    public List<IndividualCustomerResponse> getAllIndividuals() {
        return individualCustomerRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public IndividualCustomerResponse getByNationalIdentity(String nationalIdentity) {
        return mapper.toResponse(
                individualCustomerRepository.findByNationalIdentity(nationalIdentity)
        );
    }

    @Override
    public List<CustomerResponse> getAll() {
        return getAllIndividuals();
    }

    @Override
    public CustomerResponse getById(Long id) {
        return mapper.toResponse(
                individualCustomerRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public void deleteById(Long id) {
        individualCustomerRepository.deleteById(id);
    }
} 