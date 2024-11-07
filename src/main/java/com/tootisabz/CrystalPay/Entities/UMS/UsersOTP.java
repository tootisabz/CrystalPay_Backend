package com.tootisabz.CrystalPay.Entities.UMS;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "ums")
public class UsersOTP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UsersOTPID;
    private UUID UserID;
    private String VerificationCode;
    private LocalDateTime ExpiresAt;
    private boolean IsVerified;
}
