package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateCorporateCustomerRequest {
    
    @NotBlank(message = "Company name is required")
    private String companyName;
    
    @NotBlank(message = "Tax number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Tax number must be 10 digits")
    private String taxNumber;
    
    @NotBlank(message = "Trade register number is required")
    private String tradeRegisterNumber;
    
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    
    @Email(message = "Invalid email format")
    private String email;
    
    private String contactPerson;
    private String address;
} 