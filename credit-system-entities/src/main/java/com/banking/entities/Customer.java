package com.banking.entities;

import com.banking.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Customer extends BaseEntity<Long> {

    @Column(name = "customer_number", nullable = false, unique = true)
    private String customerNumber;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "address")
    private String address;
    
} 