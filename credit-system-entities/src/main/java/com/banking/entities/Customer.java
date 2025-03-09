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
public abstract class Customer extends BaseEntity {
    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "address")
    private String address;
} 