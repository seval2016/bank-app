package com.banking.business.dtos.responses;

import com.banking.entities.enums.CreditApplicationStatus;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreditApplicationSummaryResponse {
    private String applicationNumber;
    private BigDecimal amount;
    private Integer maturityMonths;
    private CreditApplicationStatus status;
    private LocalDateTime applicationDate;
    private String creditTypeName;
} 