package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCreditApplicationRequest;
import com.banking.business.dtos.responses.IndividualCreditApplicationResponse;
import com.banking.entities.IndividualCreditApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IndividualCreditApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "applicationNumber", ignore = true)
    @Mapping(target = "status", constant = "PENDING")
    @Mapping(target = "applicationDate", expression = "java(java.time.LocalDateTime.now())")
    IndividualCreditApplication toEntity(CreateIndividualCreditApplicationRequest request);
    
    IndividualCreditApplicationResponse toResponse(IndividualCreditApplication application);
} 