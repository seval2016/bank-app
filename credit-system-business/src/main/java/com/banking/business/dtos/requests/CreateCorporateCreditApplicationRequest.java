package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateCorporateCreditApplicationRequest {
    @NotNull(message = "Corporate customer ID is required")
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

    @NotNull(message = "Annual revenue is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Annual revenue must be greater than 0")
    private BigDecimal annualRevenue;

    @NotNull(message = "Company age is required")
    @Min(value = 0, message = "Company age cannot be negative")
    private Integer companyAgeYears;
} 