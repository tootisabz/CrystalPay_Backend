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
public class NFCTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID NFCTransactionsID;
//    private UUID TransactionID;
//    private UUID TokenID;
    private UUID UserID;
    private double Amount;
    private String CurrencyCode;
    private LocalDateTime ExpiresAt;
    private FinTechTransactionStatus Status;

    @ManyToOne
    @JoinColumn(name = "TransactionID", referencedColumnName = "TransactionID")
    private Transaction Transaction;

    @ManyToOne
    @JoinColumn(name = "TokenizationID", referencedColumnName = "TokenizationID")
    private Tokenization Tokenization;

}
