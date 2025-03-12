package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateIndividualCreditApplicationRequest {
    @NotNull(message = "Individual customer ID is required")
    private Long customerId;

    @NotNull(message = "Credit type ID is required")
    private Long creditTypeId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Maturity months is required")
    @Min(value = 1, message = "Maturity months must be at least 1")
    @Max(value = 120, message = "Maturity months must be at most 120")
    private Integer maturityMonths;

    @NotNull(message = "Monthly income is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Monthly income must be greater than 0")
    private BigDecimal monthlyIncome;
} 