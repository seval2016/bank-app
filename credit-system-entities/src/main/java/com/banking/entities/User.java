package com.banking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    
    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean accountNonExpired = true;

    @Column(nullable = false)
    private boolean accountNonLocked = true;

    @Column(nullable = false)
    private boolean credentialsNonExpired = true;

    @Column(nullable = false)
    private boolean enabled = true;
} 