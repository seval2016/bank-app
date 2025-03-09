package com.banking.business.dtos.responses;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CorporateCreditApplicationResponse extends CreditApplicationResponse {
    private BigDecimal annualRevenue;
    private Integer companyAgeYears;
    private CorporateCustomerResponse customer;
    private CorporateCreditTypeResponse creditType;
} 