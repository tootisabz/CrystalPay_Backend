package com.tootisabz.CrystalPay.Entities.UMS;

import com.tootisabz.CrystalPay.Common.Enums.VerifyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "ums")
public class KYC {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID KYC_ID;
    private String DocumentType;
    private String DocumentNumber;
    private Date ExpiryDate;
    private VerifyStatus VerificationStatus;
    private Date SubmissionDate;
    private String DocumentFilePath;
}
