package com.banking.business.dtos.responses;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CorporateCreditTypeResponse extends CreditTypeResponse {
    private BigDecimal minRevenue;
    private Integer minCompanyAgeYears;
} 