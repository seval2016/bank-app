package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.CorporateCustomer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapping {
    
    @Bean
    public ModelMapper modelMapper() {
       IndividualCustomer mapToIndividualCustomer(CreateIndividualCustomerRequest request);
       CorporateCustomer mapToCorporateCustomer(CreateCorporateCustomerRequest request);

       IndividualCustomerResponse mapToIndividualCustomerResponse(IndividualCustomer customer);
       CorporateCustomerResponse mapToCorporateCustomerResponse(CorporateCustomer customer);
    }
} 