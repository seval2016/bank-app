package com.banking.business.dtos.responses;

import com.banking.entities.enums.CreditApplicationStatus;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class IndividualCreditApplicationResponse extends CreditApplicationResponse {
    private Integer creditScore;
    private BigDecimal monthlyIncome;
    private IndividualCustomerResponse customer;
    private IndividualCreditTypeResponse creditType;
} 