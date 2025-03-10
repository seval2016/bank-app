package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "corporate_credit_types")
@Getter
@Setter
public class CorporateCreditType extends CreditType {
    @Column(name = "min_revenue", nullable = false)
    private BigDecimal minRevenue;
    
    @Column(name = "min_company_age_years")
    private Integer minCompanyAgeYears;
} 