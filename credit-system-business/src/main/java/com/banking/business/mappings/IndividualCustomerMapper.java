package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndividualCustomerMapper {
    IndividualCustomer toEntity(CreateIndividualCustomerRequest request);
    IndividualCustomerResponse toResponse(IndividualCustomer customer);
} 