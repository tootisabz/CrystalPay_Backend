package com.tootisabz.CrystalPay.Entities.CrystalPay;

import com.tootisabz.CrystalPay.Common.Enums.IntegrationType;
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
public class FinancialInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID FinancialInstitutionID;
    private String InstitutionName;
    private IntegrationType IntegrationType;
    private String APIDetails;
    private String ContractDate;
    private String ContractStatus;
    @OneToMany(mappedBy = "financialInstitution")
    private List<Transaction> transactions;
}
