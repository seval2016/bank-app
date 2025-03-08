package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "individual_credit_applications")
@Getter
@Setter
public class IndividualCreditApplication extends CreditApplication {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_customer_id", nullable = false)
    private IndividualCustomer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_type_id", nullable = false)
    private IndividualCreditType creditType;
    
    @Column(name = "credit_score", nullable = false)
    private Integer creditScore;
    
    @Column(name = "monthly_income", nullable = false)
    private BigDecimal monthlyIncome;
} 