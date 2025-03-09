package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCustomer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T16:43:34+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CorporateCustomerMapperImpl implements CorporateCustomerMapper {

    @Override
    public CorporateCustomer toEntity(CreateCorporateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporateCustomer corporateCustomer = new CorporateCustomer();

        corporateCustomer.setAddress( request.getAddress() );
        corporateCustomer.setEmail( request.getEmail() );
        corporateCustomer.setPhoneNumber( request.getPhoneNumber() );
        corporateCustomer.setCompanyName( request.getCompanyName() );
        corporateCustomer.setContactPerson( request.getContactPerson() );
        corporateCustomer.setTaxNumber( request.getTaxNumber() );
        corporateCustomer.setTradeRegisterNumber( request.getTradeRegisterNumber() );

        return corporateCustomer;
    }

    @Override
    public CorporateCustomerResponse toResponse(CorporateCustomer customer) {
        if ( customer == null ) {
            return null;
        }

        CorporateCustomerResponse corporateCustomerResponse = new CorporateCustomerResponse();

        corporateCustomerResponse.setAddress( customer.getAddress() );
        corporateCustomerResponse.setCustomerNumber( customer.getCustomerNumber() );
        corporateCustomerResponse.setEmail( customer.getEmail() );
        corporateCustomerResponse.setId( customer.getId() );
        corporateCustomerResponse.setPhoneNumber( customer.getPhoneNumber() );
        corporateCustomerResponse.setCompanyName( customer.getCompanyName() );
        corporateCustomerResponse.setContactPerson( customer.getContactPerson() );
        corporateCustomerResponse.setTaxNumber( customer.getTaxNumber() );
        corporateCustomerResponse.setTradeRegisterNumber( customer.getTradeRegisterNumber() );

        return corporateCustomerResponse;
    }
}
