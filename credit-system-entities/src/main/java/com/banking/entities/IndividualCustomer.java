package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "individual_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
@Getter
@Setter
public class IndividualCustomer extends Customer {
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "national_identity", nullable = false, unique = true, length = 11)
    private String nationalIdentity;
    
    @Column(name = "birth_date")
    private String birthDate;
} 