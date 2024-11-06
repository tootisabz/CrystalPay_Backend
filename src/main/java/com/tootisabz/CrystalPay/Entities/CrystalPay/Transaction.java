package com.tootisabz.CrystalPay.Entities.CrystalPay;

import com.tootisabz.CrystalPay.Common.Enums.FinTechTransactionStatus;
import com.tootisabz.CrystalPay.Common.Enums.TransactionType;
import com.tootisabz.CrystalPay.Entities.UMS.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TransactionID;
//    private UUID FinancialInstitutionID;
//    private UUID IssuerUserID;
//    private UUID AcquirerUserID;
    private UUID FromWalletAccountID;
    private UUID ToWalletAccountID;
    private UUID FromPaymentMethodID;
    private UUID ToPaymentMethodID;
    private double Amount;
    private double DeductedFeeAmount;
    private String CurrencyCode;
    private TransactionType TransactionType;
    private FinTechTransactionStatus Status;
    private LocalDateTime TransactionDate;
    private String Description;
    @ManyToOne
    @JoinColumn(name = "FinancialInstitutionID", referencedColumnName = "FinancialInstitutionID")
    private FinancialInstitution financialInstitution;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IssuerUserID", referencedColumnName = "UserID")
    private Users issuerUser;

    @ManyToOne
    @JoinColumn(name = "AcquirerUserID", referencedColumnName = "UserID")
    private Users acquirerUser;

    @OneToMany
    @JoinColumn(name = "TransactionID", referencedColumnName = "TransactionID")
    private List<TransactionHistory> TransactionHistory;

}
