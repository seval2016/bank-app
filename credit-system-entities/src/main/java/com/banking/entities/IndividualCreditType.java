package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "individual_credit_types")
@Getter
@Setter
public class IndividualCreditType extends CreditType {
    @Column(name = "min_credit_score", nullable = false)
    private Integer minCreditScore;
    
    @Column(name = "max_maturity_months")
    private Integer maxMaturityMonths;
} 