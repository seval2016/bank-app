package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCreditTypeRequest;
import com.banking.business.dtos.responses.CreditTypeResponse;
import com.banking.entities.CreditType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CreditTypeMapper {
    CreditType toEntity(CreateCreditTypeRequest request);
    CreditTypeResponse toResponse(CreditType creditType);
    void update(CreateCreditTypeRequest request, @MappingTarget CreditType creditType);
} 