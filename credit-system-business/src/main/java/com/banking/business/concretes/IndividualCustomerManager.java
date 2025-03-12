package com.banking.business.concretes;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.business.mappings.IndividualCustomerMapper;
import com.banking.business.rules.CustomerBusinessRules;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.Customer;
import com.banking.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.banking.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.banking.business.constants.Messages;
import com.banking.business.dtos.responses.PaginatedResponse;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerBusinessRules rules;
    private final IndividualCustomerMapper mapper;

    @Override
    public IndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        rules.checkIfEmailExists(request.getEmail());
        checkIfNationalIdentityExists(request.getNationalIdentity());
        
        IndividualCustomer customer = mapper.toEntity(request);
        customer.setCustomerNumber(UUID.randomUUID().toString());
        
        individualCustomerRepository.save(customer);
        return mapper.toResponse(customer);
    }

    private void checkIfNationalIdentityExists(String nationalIdentity) {
        if (individualCustomerRepository.existsByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Customer.NATIONAL_IDENTITY_ALREADY_EXISTS, "NATIONAL_IDENTITY_EXISTS");
        }
    }

    @Override
    public IndividualCustomerResponse getByNationalIdentity(String nationalIdentity) {
        return mapper.toResponse(
                individualCustomerRepository.findByNationalIdentity(nationalIdentity)
        );
    }

    @Override
    public PaginatedResponse<IndividualCustomerResponse> getAllPaginated(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        
        Page<IndividualCustomer> customerPage = individualCustomerRepository.findAll(pageable);
        List<IndividualCustomerResponse> customerResponses = customerPage.getContent()
                .stream()
                .map(mapper::toResponse)
                .toList();
        
        return new PaginatedResponse<>(
                customerResponses,
                customerPage.getNumber(),
                customerPage.getSize(),
                customerPage.getTotalElements(),
                customerPage.getTotalPages(),
                customerPage.isFirst(),
                customerPage.isLast(),
                customerPage.hasNext(),
                customerPage.hasPrevious()
        );
    }

    @Override
    public List<Customer> getAllCustomers() {
        return individualCustomerRepository.findAll().stream()
                .map(customer -> (Customer) customer)
                .toList();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return individualCustomerRepository.findById(id).map(customer -> (Customer) customer);
    }

    @Override
    public Optional<Customer> getCustomerByNumber(String customerNumber) {
        return Optional.ofNullable(individualCustomerRepository.findByCustomerNumber(customerNumber))
                .map(customer -> (Customer) customer);
    }

    @Override
    public void validateCustomerNumber(String customerNumber) {
        if (individualCustomerRepository.existsByCustomerNumber(customerNumber)) {
            throw new RuntimeException(Messages.Customer.CUSTOMER_NUMBER_ALREADY_EXISTS);
        }
    }
} 