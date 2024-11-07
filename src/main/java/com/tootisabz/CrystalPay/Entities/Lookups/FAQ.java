package com.tootisabz.CrystalPay.Entities.Lookups;

import com.tootisabz.CrystalPay.Common.Enums.FaqCategory;
import com.tootisabz.CrystalPay.Common.Enums.TransactionType;
import com.tootisabz.CrystalPay.Entities.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "lookup")
public class FAQ extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID FaqID;
    private String Question;
    private String Answer;
    private FaqCategory Category;
    private boolean IsVisible;
}
