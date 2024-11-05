package com.tootisabz.CrystalPay.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class AuditableEntity {
    @Column(nullable = false)
    private UUID CreatedBy;
    @Column(nullable = false)
    private LocalDateTime CreatedDate;
    private LocalDateTime ModifiedDate;
    private UUID ModifiedBy;
}
