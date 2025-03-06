package com.banking.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
@Getter
@Setter
public class CorporateCustomer extends Customer {
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    
    @Column(name = "trade_register_number", unique = true)
    private String tradeRegisterNumber;
    
    @Column(name = "contact_person")
    private String contactPerson;
    

} 