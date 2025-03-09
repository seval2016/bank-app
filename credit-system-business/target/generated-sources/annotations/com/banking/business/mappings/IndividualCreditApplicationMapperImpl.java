package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateIndividualCreditApplicationRequest;
import com.banking.business.dtos.responses.IndividualCreditApplicationResponse;
import com.banking.business.dtos.responses.IndividualCreditTypeResponse;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.IndividualCreditApplication;
import com.banking.entities.IndividualCreditType;
import com.banking.entities.IndividualCustomer;
import com.banking.entities.enums.CreditApplicationStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T16:43:38+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class IndividualCreditApplicationMapperImpl implements IndividualCreditApplicationMapper {

    @Override
    public IndividualCreditApplication toEntity(CreateIndividualCreditApplicationRequest request) {
        if ( request == null ) {
            return null;
        }

        IndividualCreditApplication individualCreditApplication = new IndividualCreditApplication();

        individualCreditApplication.setAmount( request.getAmount() );
        individualCreditApplication.setMaturityMonths( request.getMaturityMonths() );
        individualCreditApplication.setMonthlyIncome( request.getMonthlyIncome() );

        individualCreditApplication.setStatus( CreditApplicationStatus.PENDING );
        individualCreditApplication.setApplicationDate( java.time.LocalDateTime.now() );

        return individualCreditApplication;
    }

    @Override
    public IndividualCreditApplicationResponse toResponse(IndividualCreditApplication application) {
        if ( application == null ) {
            return null;
        }

        IndividualCreditApplicationResponse individualCreditApplicationResponse = new IndividualCreditApplicationResponse();

        individualCreditApplicationResponse.setAmount( application.getAmount() );
        individualCreditApplicationResponse.setApplicationDate( application.getApplicationDate() );
        individualCreditApplicationResponse.setApplicationNumber( application.getApplicationNumber() );
        individualCreditApplicationResponse.setCreditType( individualCreditTypeToIndividualCreditTypeResponse( application.getCreditType() ) );
        individualCreditApplicationResponse.setCustomer( individualCustomerToIndividualCustomerResponse( application.getCustomer() ) );
        individualCreditApplicationResponse.setId( application.getId() );
        individualCreditApplicationResponse.setInterestRate( application.getInterestRate() );
        individualCreditApplicationResponse.setMaturityMonths( application.getMaturityMonths() );
        individualCreditApplicationResponse.setRejectionReason( application.getRejectionReason() );
        individualCreditApplicationResponse.setResultDate( application.getResultDate() );
        individualCreditApplicationResponse.setStatus( application.getStatus() );
        individualCreditApplicationResponse.setCreditScore( application.getCreditScore() );
        individualCreditApplicationResponse.setMonthlyIncome( application.getMonthlyIncome() );

        return individualCreditApplicationResponse;
    }

    protected IndividualCreditTypeResponse individualCreditTypeToIndividualCreditTypeResponse(IndividualCreditType individualCreditType) {
        if ( individualCreditType == null ) {
            return null;
        }

        IndividualCreditTypeResponse individualCreditTypeResponse = new IndividualCreditTypeResponse();

        individualCreditTypeResponse.setBaseInterestRate( individualCreditType.getBaseInterestRate() );
        individualCreditTypeResponse.setDescription( individualCreditType.getDescription() );
        individualCreditTypeResponse.setId( individualCreditType.getId() );
        individualCreditTypeResponse.setMaxAmount( individualCreditType.getMaxAmount() );
        individualCreditTypeResponse.setMinAmount( individualCreditType.getMinAmount() );
        individualCreditTypeResponse.setName( individualCreditType.getName() );
        individualCreditTypeResponse.setMaxMaturityMonths( individualCreditType.getMaxMaturityMonths() );
        individualCreditTypeResponse.setMinCreditScore( individualCreditType.getMinCreditScore() );

        return individualCreditTypeResponse;
    }

    protected IndividualCustomerResponse individualCustomerToIndividualCustomerResponse(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        IndividualCustomerResponse individualCustomerResponse = new IndividualCustomerResponse();

        individualCustomerResponse.setAddress( individualCustomer.getAddress() );
        individualCustomerResponse.setCustomerNumber( individualCustomer.getCustomerNumber() );
        individualCustomerResponse.setEmail( individualCustomer.getEmail() );
        individualCustomerResponse.setId( individualCustomer.getId() );
        individualCustomerResponse.setPhoneNumber( individualCustomer.getPhoneNumber() );
        individualCustomerResponse.setBirthDate( individualCustomer.getBirthDate() );
        individualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        individualCustomerResponse.setLastName( individualCustomer.getLastName() );
        individualCustomerResponse.setNationalIdentity( individualCustomer.getNationalIdentity() );

        return individualCustomerResponse;
    }
}
