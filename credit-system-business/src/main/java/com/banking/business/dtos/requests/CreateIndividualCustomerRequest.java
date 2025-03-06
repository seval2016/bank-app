package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateIndividualCustomerRequest {
    
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    @NotBlank(message = "National identity is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "National identity must be 11 digits")
    private String nationalIdentity;
    
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    
    @Email(message = "Invalid email format")
    private String email;
    
    private String birthDate;
    private String address;
} 