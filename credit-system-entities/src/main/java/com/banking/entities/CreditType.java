package com.banking.entities;

import com.banking.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "credit_types")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class CreditType extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;
    
    @Column(name = "max_amount", nullable = false)
    private BigDecimal maxAmount;
    
    @Column(name = "base_interest_rate", nullable = false)
    private BigDecimal baseInterestRate;
} 