package com.banking.business.mappings;

import com.banking.business.dtos.requests.CreateCorporateCreditApplicationRequest;
import com.banking.business.dtos.responses.CorporateCreditApplicationResponse;
import com.banking.business.dtos.responses.CorporateCreditTypeResponse;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCreditApplication;
import com.banking.entities.CorporateCreditType;
import com.banking.entities.CorporateCustomer;
import com.banking.entities.enums.CreditApplicationStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T16:43:34+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class CorporateCreditApplicationMapperImpl implements CorporateCreditApplicationMapper {

    @Override
    public CorporateCreditApplication toEntity(CreateCorporateCreditApplicationRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporateCreditApplication corporateCreditApplication = new CorporateCreditApplication();

        corporateCreditApplication.setAmount( request.getAmount() );
        corporateCreditApplication.setMaturityMonths( request.getMaturityMonths() );
        corporateCreditApplication.setAnnualRevenue( request.getAnnualRevenue() );
        corporateCreditApplication.setCompanyAgeYears( request.getCompanyAgeYears() );

        corporateCreditApplication.setStatus( CreditApplicationStatus.PENDING );
        corporateCreditApplication.setApplicationDate( java.time.LocalDateTime.now() );

        return corporateCreditApplication;
    }

    @Override
    public CorporateCreditApplicationResponse toResponse(CorporateCreditApplication application) {
        if ( application == null ) {
            return null;
        }

        CorporateCreditApplicationResponse corporateCreditApplicationResponse = new CorporateCreditApplicationResponse();

        corporateCreditApplicationResponse.setAmount( application.getAmount() );
        corporateCreditApplicationResponse.setApplicationDate( application.getApplicationDate() );
        corporateCreditApplicationResponse.setApplicationNumber( application.getApplicationNumber() );
        corporateCreditApplicationResponse.setCreditType( corporateCreditTypeToCorporateCreditTypeResponse( application.getCreditType() ) );
        corporateCreditApplicationResponse.setCustomer( corporateCustomerToCorporateCustomerResponse( application.getCustomer() ) );
        corporateCreditApplicationResponse.setId( application.getId() );
        corporateCreditApplicationResponse.setInterestRate( application.getInterestRate() );
        corporateCreditApplicationResponse.setMaturityMonths( application.getMaturityMonths() );
        corporateCreditApplicationResponse.setRejectionReason( application.getRejectionReason() );
        corporateCreditApplicationResponse.setResultDate( application.getResultDate() );
        corporateCreditApplicationResponse.setStatus( application.getStatus() );
        corporateCreditApplicationResponse.setAnnualRevenue( application.getAnnualRevenue() );
        corporateCreditApplicationResponse.setCompanyAgeYears( application.getCompanyAgeYears() );

        return corporateCreditApplicationResponse;
    }

    protected CorporateCreditTypeResponse corporateCreditTypeToCorporateCreditTypeResponse(CorporateCreditType corporateCreditType) {
        if ( corporateCreditType == null ) {
            return null;
        }

        CorporateCreditTypeResponse corporateCreditTypeResponse = new CorporateCreditTypeResponse();

        corporateCreditTypeResponse.setBaseInterestRate( corporateCreditType.getBaseInterestRate() );
        corporateCreditTypeResponse.setDescription( corporateCreditType.getDescription() );
        corporateCreditTypeResponse.setId( corporateCreditType.getId() );
        corporateCreditTypeResponse.setMaxAmount( corporateCreditType.getMaxAmount() );
        corporateCreditTypeResponse.setMinAmount( corporateCreditType.getMinAmount() );
        corporateCreditTypeResponse.setName( corporateCreditType.getName() );
        corporateCreditTypeResponse.setMinCompanyAgeYears( corporateCreditType.getMinCompanyAgeYears() );
        corporateCreditTypeResponse.setMinRevenue( corporateCreditType.getMinRevenue() );

        return corporateCreditTypeResponse;
    }

    protected CorporateCustomerResponse corporateCustomerToCorporateCustomerResponse(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        CorporateCustomerResponse corporateCustomerResponse = new CorporateCustomerResponse();

        corporateCustomerResponse.setAddress( corporateCustomer.getAddress() );
        corporateCustomerResponse.setCustomerNumber( corporateCustomer.getCustomerNumber() );
        corporateCustomerResponse.setEmail( corporateCustomer.getEmail() );
        corporateCustomerResponse.setId( corporateCustomer.getId() );
        corporateCustomerResponse.setPhoneNumber( corporateCustomer.getPhoneNumber() );
        corporateCustomerResponse.setCompanyName( corporateCustomer.getCompanyName() );
        corporateCustomerResponse.setContactPerson( corporateCustomer.getContactPerson() );
        corporateCustomerResponse.setTaxNumber( corporateCustomer.getTaxNumber() );
        corporateCustomerResponse.setTradeRegisterNumber( corporateCustomer.getTradeRegisterNumber() );

        return corporateCustomerResponse;
    }
}
