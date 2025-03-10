package com.banking.entities;

import com.banking.core.entities.BaseEntity;
import com.banking.entities.enums.CreditApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "credit_applications")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
public abstract class CreditApplication extends BaseEntity {
    @Column(name = "application_number", unique = true, nullable = false)
    private String applicationNumber;
    
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    
    @Column(name = "maturity_months", nullable = false)
    private Integer maturityMonths;
    
    @Column(name = "interest_rate", nullable = false)
    private BigDecimal interestRate;
    
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditApplicationStatus status;
    
    @Column(name = "application_date", nullable = false)
    private LocalDateTime applicationDate;
    
    @Column(name = "result_date")
    private LocalDateTime resultDate;
    
    @Column(name = "rejection_reason")
    private String rejectionReason;
} 