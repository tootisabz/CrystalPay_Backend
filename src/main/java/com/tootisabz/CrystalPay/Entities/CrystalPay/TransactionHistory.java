package com.tootisabz.CrystalPay.Entities.CrystalPay;

import com.tootisabz.CrystalPay.Common.Enums.FinTechTransactionStatus;
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
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TransactionHistoryID;
    private UUID TransactionID;
    private FinTechTransactionStatus Status;
    private LocalDateTime DateTime;
}
