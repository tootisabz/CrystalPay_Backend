package com.tootisabz.CrystalPay.Entities.CrystalPay;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID BankID;
    private String Bin;
    private String BankName;
    private boolean HasCVV2;
}
