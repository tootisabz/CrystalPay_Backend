package com.tootisabz.CrystalPay.Entities.Lookups;

import com.tootisabz.CrystalPay.Entities.UMS.Permission;
import com.tootisabz.CrystalPay.Entities.UMS.Users;
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
public class UserCurrencies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UserCurrenciesID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "CurrencyID", referencedColumnName = "CurrencyID")
    private Currencies Currencies;
}
