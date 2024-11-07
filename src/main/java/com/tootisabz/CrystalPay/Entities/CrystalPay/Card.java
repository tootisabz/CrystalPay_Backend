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
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID CardID;
    private UUID UserID;
//    private UUID BankID;
    private String MethodType;
    private String Provider;
    private String AccountNumber;

    @ManyToOne
    @JoinColumn(name = "BankID", referencedColumnName = "BankID")
    private Bank Bank;
    @OneToMany
    @JoinColumn(name = "FromCardID",referencedColumnName = "CardID")
    private List<Transaction> IssuedTransactions;
    @OneToMany
    @JoinColumn(name = "ToCardID",referencedColumnName = "CardID")
    private List<Transaction> AcquiredTransactions;
}
