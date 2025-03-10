package com.banking.business.dtos.responses;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String customerNumber;
    private String email;
    private String phoneNumber;
    private String address;
} 