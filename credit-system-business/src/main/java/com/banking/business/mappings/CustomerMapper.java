package com.banking.business.mappings;

import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toResponse(Customer customer);
} 