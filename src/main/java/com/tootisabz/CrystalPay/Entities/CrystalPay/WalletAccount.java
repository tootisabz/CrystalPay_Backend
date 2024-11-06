package com.tootisabz.CrystalPay.Entities.CrystalPay;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project")
public class WalletAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID WalletAccountID;
    private UUID UserID;
    private String CurrencyCode;
    private double Balance;
    private String Description;
    @OneToMany
    @JoinColumn(name = "FromWalletAccountID",referencedColumnName = "WalletAccountID")
    private List<Transaction> IssuedTransactions;
    @OneToMany
    @JoinColumn(name = "ToWalletAccountID",referencedColumnName = "WalletAccountID")
    private List<Transaction> AcquiredTransactions;
}
