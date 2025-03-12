package com.banking.business.concretes;

import com.banking.business.abstracts.CustomerService;
import com.banking.entities.Customer;
import com.banking.repositories.abstracts.CustomerRepository;
import com.banking.business.mappings.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerByNumber(String customerNumber) {
        return Optional.ofNullable(customerRepository.findByCustomerNumber(customerNumber));
    }

    @Override
    public void validateCustomerNumber(String customerNumber) {
        if (customerRepository.existsByCustomerNumber(customerNumber)) {
            throw new RuntimeException("Customer number already exists");
        }
    }
} 