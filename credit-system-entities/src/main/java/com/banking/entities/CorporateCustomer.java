package com.banking.entities;

import jakarta.persistence.*;
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
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    
    @Column(name = "trade_register_number", nullable = false, unique = true)
    private String tradeRegisterNumber;
    
    @Column(name = "contact_person")
    private String contactPerson;
}