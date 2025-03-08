package com.banking.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateIndividualCustomerRequest {
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @NotBlank(message = "National identity number is required")
    @Pattern(regexp = "^[0-9]{11}$", message = "National identity number must be 11 digits")
    private String nationalIdentity;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be maximum 100 characters")
    private String email;
    
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birth date must be in format YYYY-MM-DD")
    private String birthDate;
    
    @Size(max = 200, message = "Address must be maximum 200 characters")
    private String address;
} 