package com.banking.business.dtos.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
} 