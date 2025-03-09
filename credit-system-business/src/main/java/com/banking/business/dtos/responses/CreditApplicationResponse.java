package com.banking.business.dtos.responses;

import com.banking.entities.enums.CreditApplicationStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreditApplicationResponse {
    private Long id;
    private String applicationNumber;
    private BigDecimal amount;
    private Integer maturityMonths;
    private BigDecimal interestRate;
    private CreditApplicationStatus status;
    private LocalDateTime applicationDate;
    private LocalDateTime resultDate;
    private String rejectionReason;
    private CustomerResponse customer;
    private CreditTypeResponse creditType;
} 