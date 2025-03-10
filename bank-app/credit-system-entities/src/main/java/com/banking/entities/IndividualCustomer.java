package com.banking.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "individual_customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IndividualCustomer extends BaseEntity {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "national_identity", nullable = false, unique = true, length = 11)
    private String nationalIdentity;
    
    @Column(name = "birth_date")
    private String birthDate;
} 