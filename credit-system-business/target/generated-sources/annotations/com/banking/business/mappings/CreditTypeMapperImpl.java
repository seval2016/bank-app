package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCreditTypeRequest;
import com.banking.business.dtos.responses.CreditTypeResponse;
import com.banking.entities.CreditType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T01:12:09+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CreditTypeMapperImpl implements CreditTypeMapper {

    @Override
    public CreditType toEntity(CreateCreditTypeRequest request) {
        if ( request == null ) {
            return null;
        }

        CreditType creditType = new CreditType();

        creditType.setDescription( request.getDescription() );
        creditType.setInterestRate( request.getInterestRate() );
        creditType.setMaxAmount( request.getMaxAmount() );
        creditType.setMaxTerm( request.getMaxTerm() );
        creditType.setMinAmount( request.getMinAmount() );
        creditType.setMinTerm( request.getMinTerm() );
        creditType.setName( request.getName() );

        return creditType;
    }

    @Override
    public CreditTypeResponse toResponse(CreditType creditType) {
        if ( creditType == null ) {
            return null;
        }

        CreditTypeResponse creditTypeResponse = new CreditTypeResponse();

        creditTypeResponse.setDescription( creditType.getDescription() );
        creditTypeResponse.setId( creditType.getId() );
        creditTypeResponse.setInterestRate( creditType.getInterestRate() );
        creditTypeResponse.setMaxAmount( creditType.getMaxAmount() );
        creditTypeResponse.setMaxTerm( creditType.getMaxTerm() );
        creditTypeResponse.setMinAmount( creditType.getMinAmount() );
        creditTypeResponse.setMinTerm( creditType.getMinTerm() );
        creditTypeResponse.setName( creditType.getName() );

        return creditTypeResponse;
    }

    @Override
    public void update(CreateCreditTypeRequest request, CreditType creditType) {
        if ( request == null ) {
            return;
        }

        creditType.setDescription( request.getDescription() );
        creditType.setInterestRate( request.getInterestRate() );
        creditType.setMaxAmount( request.getMaxAmount() );
        creditType.setMaxTerm( request.getMaxTerm() );
        creditType.setMinAmount( request.getMinAmount() );
        creditType.setMinTerm( request.getMinTerm() );
        creditType.setName( request.getName() );
    }
}
