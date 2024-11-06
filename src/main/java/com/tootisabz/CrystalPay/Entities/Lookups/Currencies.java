package com.tootisabz.CrystalPay.Entities.Lookups;

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
public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID CurrencyID;
    private String CurrencyName;
    private String CurrencySymbol;
    private String CurrencyCode;
    private String CurrencyNumericCode;

}
