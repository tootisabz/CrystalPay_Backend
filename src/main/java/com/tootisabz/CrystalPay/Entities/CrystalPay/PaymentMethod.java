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
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID PaymentMethodID;
    private UUID UserID;
    private String MethodType;
    private String Provider;
    private String AccountNumber;

    @OneToMany
    @JoinColumn(name = "FromPaymentMethodID",referencedColumnName = "PaymentMethodID")
    private List<Transaction> IssuedTransactions;
    @OneToMany
    @JoinColumn(name = "ToPaymentMethodID",referencedColumnName = "PaymentMethodID")
    private List<Transaction> AcquiredTransactions;
}
