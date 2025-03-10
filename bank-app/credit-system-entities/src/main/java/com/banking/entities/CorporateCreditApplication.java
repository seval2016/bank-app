package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;


@Entity
@Table(name = "corporate_credit_applications")
@Getter
@Setter
@ToString(callSuper = true)
public class CorporateCreditApplication extends CreditApplication {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corporate_customer_id", nullable = false)
    private CorporateCustomer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_type_id", nullable = false)
    private CorporateCreditType creditType;
    
    @Column(name = "annual_revenue", nullable = false)
    private BigDecimal annualRevenue;
    
    @Column(name = "company_age_years", nullable = false)
    private Integer companyAgeYears;
} 