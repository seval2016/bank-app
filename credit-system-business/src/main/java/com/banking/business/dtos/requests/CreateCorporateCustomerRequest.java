package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateCorporateCustomerRequest {
    
    @NotBlank(message = "Company name is required")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    private String companyName;
    
    @NotBlank(message = "Tax number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Tax number must be 10 digits")
    private String taxNumber;
    
    @NotBlank(message = "Trade register number is required")
    @Size(min = 5, max = 20, message = "Trade register number must be between 5 and 20 characters")
    private String tradeRegisterNumber;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be maximum 100 characters")
    private String email;
    
    @Size(min = 2, max = 100, message = "Contact person must be between 2 and 100 characters")
    private String contactPerson;
    
    @Size(max = 200, message = "Address must be maximum 200 characters")
    private String address;
} 