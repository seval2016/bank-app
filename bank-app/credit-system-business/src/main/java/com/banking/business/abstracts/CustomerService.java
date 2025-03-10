package com.banking.business.abstracts;

import com.banking.business.dtos.responses.CustomerResponse;
import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAll();
    CustomerResponse getById(Long id);
    void deleteById(Long id);
} 