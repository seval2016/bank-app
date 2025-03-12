package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCreditApplicationRequest;
import com.banking.business.dtos.responses.CorporateCreditApplicationResponse;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCreditApplication;
import com.banking.entities.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CorporateCreditApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "applicationNumber", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "applicationDate", expression = "java(java.time.LocalDateTime.now())")
    CorporateCreditApplication toEntity(CreateCorporateCreditApplicationRequest request);
    
    @Mapping(target = "email", expression = "java(corporateCustomer.getUser().getEmail())")
    CorporateCustomerResponse corporateCustomerToCorporateCustomerResponse(CorporateCustomer corporateCustomer);

    CorporateCreditApplicationResponse toResponse(CorporateCreditApplication application);
} 