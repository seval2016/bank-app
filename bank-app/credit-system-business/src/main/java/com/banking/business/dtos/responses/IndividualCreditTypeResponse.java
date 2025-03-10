package com.banking.business.dtos.responses;

import lombok.Data;

@Data
public class IndividualCreditTypeResponse extends CreditTypeResponse {
    private Integer minCreditScore;
    private Integer maxMaturityMonths;
} 