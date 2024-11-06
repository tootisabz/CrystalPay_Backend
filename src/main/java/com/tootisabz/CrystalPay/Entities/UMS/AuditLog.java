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
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID AuditLogID;
    private UUID UserID;
    private String Action;
    private LocalDateTime DateTime;
    private String IpAddress;
    private String OsType;
    private String BrowserType;
}
