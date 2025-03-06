package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.CorporateCustomer;
import com.banking.entities.Customer;
import com.banking.business.dtos.responses.CustomerResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    
    @Bean
    public ModelMapper modelMapper() {
       IndividualCustomer mapToIndividualCustomer(CreateIndividualCustomerRequest request);
       CorporateCustomer mapToCorporateCustomer(CreateCorporateCustomerRequest request);

       IndividualCustomerResponse mapToIndividualCustomerResponse(IndividualCustomer customer);
       CorporateCustomerResponse mapToCorporateCustomerResponse(CorporateCustomer customer);
    }

    CustomerResponse toResponse(Customer customer);
} 