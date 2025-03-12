package com.banking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "credit_types")
public class CreditType extends BaseEntity {
    private String name;
    private String description;
    private double minAmount;
    private double maxAmount;
    private int minTerm;
    private int maxTerm;
    private double interestRate;
} 