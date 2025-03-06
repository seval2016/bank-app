package com.banking.business.concretes;

import com.banking.business.abstracts.CustomerService;
import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.repositories.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerResponse.class))
                .toList();
    }

    @Override
    public CustomerResponse getById(Long id) {
        return modelMapper.map(
                customerRepository.findById(id).orElseThrow(),
                CustomerResponse.class
        );
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
} 