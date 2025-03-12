package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCustomer;
import com.banking.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorporateCustomerMapper {
    @Mapping(target = "user", expression = "java(User.builder().email(request.getEmail()).build())")
    CorporateCustomer toEntity(CreateCorporateCustomerRequest request);

    @Mapping(target = "email", expression = "java(customer.getUser().getEmail())")
    CorporateCustomerResponse toResponse(CorporateCustomer customer);
} 