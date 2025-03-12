package com.banking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {
    
    @NotBlank(message = "Customer number cannot be empty")
    @Pattern(regexp = "^[A-Z]{2}\\d{8}$", message = "Customer number must be in format: XX12345678")
    @Column(name = "customer_number", nullable = false, unique = true)
    private String customerNumber;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[1-9]\\d{10,14}$", message = "Please provide a valid phone number")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Column(nullable = false, length = 500)
    private String address;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
} 