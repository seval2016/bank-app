package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateCreditTypeRequest {
    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Description is required")
    private String description;
    
    @Positive(message = "Minimum amount must be positive")
    private double minAmount;
    
    @Positive(message = "Maximum amount must be positive")
    private double maxAmount;
    
    @Min(value = 1, message = "Minimum term must be at least 1")
    private int minTerm;
    
    @Positive(message = "Maximum term must be positive")
    private int maxTerm;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Interest rate must be positive")
    @DecimalMax(value = "1.0", message = "Interest rate must be less than or equal to 1")
    private double interestRate;
} 