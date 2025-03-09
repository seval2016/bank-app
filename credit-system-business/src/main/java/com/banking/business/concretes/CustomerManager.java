package com.banking.business.concretes;

import com.banking.business.abstracts.CustomerService;
import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.repositories.abstracts.CustomerRepository;
import com.banking.business.mappings.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public CustomerResponse getById(Long id) {
        return mapper.toResponse(
                customerRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
} 