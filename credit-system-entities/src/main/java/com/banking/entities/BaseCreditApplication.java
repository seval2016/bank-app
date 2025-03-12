package com.banking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseCreditApplication extends BaseEntity {
    @Column(unique = true)
    private String applicationNumber;
    private LocalDateTime applicationDate;
    private String status;
    private Long customerId;
} 