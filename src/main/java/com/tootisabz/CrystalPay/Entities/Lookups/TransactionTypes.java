package com.tootisabz.CrystalPay.Entities.Lookups;

import com.tootisabz.CrystalPay.Common.Enums.TransactionType;
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
@Table(schema = "lookup")
public class TransactionTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TransactionTypeID;
    private String Code;
    private String TransactionTypeName;
    private String ProcessingCode;
    private TransactionType EnumValue;
}
