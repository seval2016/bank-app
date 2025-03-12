package com.banking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "individual_customers")
@EqualsAndHashCode(callSuper = true)
public class IndividualCustomer extends Customer {
    
    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @NotBlank(message = "National identity cannot be empty")
    @Pattern(regexp = "^\\d{11}$", message = "National identity must be 11 digits")
    @Column(name = "national_identity", nullable = false, unique = true)
    private String nationalIdentity;
    
    @Column(name = "monthly_income")
    private Double monthlyIncome;
    
    @Column(name = "credit_score")
    private Integer creditScore;
} 