package com.banking.business.mappings;

import com.banking.business.dtos.responses.CustomerResponse;
import com.banking.entities.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T16:43:34+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setAddress( customer.getAddress() );
        customerResponse.setCustomerNumber( customer.getCustomerNumber() );
        customerResponse.setEmail( customer.getEmail() );
        customerResponse.setId( customer.getId() );
        customerResponse.setPhoneNumber( customer.getPhoneNumber() );

        return customerResponse;
    }
}
