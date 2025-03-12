package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndividualCustomerMapper {
    @Mapping(target = "user", expression = "java(User.builder().email(request.getEmail()).build())")
    IndividualCustomer toEntity(CreateIndividualCustomerRequest request);

    @Mapping(target = "email", expression = "java(customer.getUser().getEmail())")
    IndividualCustomerResponse toResponse(IndividualCustomer customer);
} 