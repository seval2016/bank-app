package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorporateCustomerMapper {
    CorporateCustomer toEntity(CreateCorporateCustomerRequest request);
    CorporateCustomerResponse toResponse(CorporateCustomer customer);
} 