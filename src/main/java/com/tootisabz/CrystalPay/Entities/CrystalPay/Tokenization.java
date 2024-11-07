package com.tootisabz.CrystalPay.Entities.CrystalPay;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project")
public class Tokenization {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TokenizationID;
    private UUID UserID;
    private String TokenValue;
    private LocalDateTime CreatedAt;
    private LocalDateTime ExpiresAt;
}
