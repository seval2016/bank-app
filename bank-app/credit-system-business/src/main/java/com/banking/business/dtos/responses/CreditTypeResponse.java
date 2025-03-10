package com.banking.business.dtos.responses;

import lombok.Data;

@Data
public class CreditTypeResponse {
    private Long id;
    private String name;
    private String description;
    private double minAmount;
    private double maxAmount;
    private int minTerm;
    private int maxTerm;
    private double interestRate;
} 