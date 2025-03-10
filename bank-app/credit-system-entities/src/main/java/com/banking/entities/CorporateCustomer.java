package com.banking.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "corporate_customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CorporateCustomer extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    
    @Column(name = "trade_register_number", nullable = false, unique = true)
    private String tradeRegisterNumber;
    
    @Column(name = "contact_person")
    private String contactPerson;
} 