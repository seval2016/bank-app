package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.IndividualCustomer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T16:43:35+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class IndividualCustomerMapperImpl implements IndividualCustomerMapper {

    @Override
    public IndividualCustomer toEntity(CreateIndividualCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setAddress( request.getAddress() );
        individualCustomer.setEmail( request.getEmail() );
        individualCustomer.setPhoneNumber( request.getPhoneNumber() );
        individualCustomer.setBirthDate( request.getBirthDate() );
        individualCustomer.setFirstName( request.getFirstName() );
        individualCustomer.setLastName( request.getLastName() );
        individualCustomer.setNationalIdentity( request.getNationalIdentity() );

        return individualCustomer;
    }

    @Override
    public IndividualCustomerResponse toResponse(IndividualCustomer customer) {
        if ( customer == null ) {
            return null;
        }

        IndividualCustomerResponse individualCustomerResponse = new IndividualCustomerResponse();

        individualCustomerResponse.setAddress( customer.getAddress() );
        individualCustomerResponse.setCustomerNumber( customer.getCustomerNumber() );
        individualCustomerResponse.setEmail( customer.getEmail() );
        individualCustomerResponse.setId( customer.getId() );
        individualCustomerResponse.setPhoneNumber( customer.getPhoneNumber() );
        individualCustomerResponse.setBirthDate( customer.getBirthDate() );
        individualCustomerResponse.setFirstName( customer.getFirstName() );
        individualCustomerResponse.setLastName( customer.getLastName() );
        individualCustomerResponse.setNationalIdentity( customer.getNationalIdentity() );

        return individualCustomerResponse;
    }
}
