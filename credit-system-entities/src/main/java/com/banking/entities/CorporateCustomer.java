package com.banking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "corporate_customers")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CorporateCustomer extends Customer {
    
    @NotBlank(message = "Company name cannot be empty")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @NotBlank(message = "Tax number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Tax number must be 10 digits")
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    
    @NotBlank(message = "Trade register number cannot be empty")
    @Pattern(regexp = "^\\d{8}$", message = "Trade register number must be 8 digits")
    @Column(name = "trade_register_number", nullable = false, unique = true)
    private String tradeRegisterNumber;
    
    @Size(min = 2, max = 100, message = "Contact person name must be between 2 and 100 characters")
    @Column(name = "contact_person")
    private String contactPerson;
    
    @Column(name = "annual_revenue")
    private Double annualRevenue;
    
    @Column(name = "number_of_employees")
    private Integer numberOfEmployees;
    
    @Column(name = "company_credit_score")
    private Integer companyCreditScore;
}