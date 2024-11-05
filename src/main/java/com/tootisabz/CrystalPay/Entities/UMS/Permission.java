package com.tootisabz.CrystalPay.Entities.UMS;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "ums")
public class Permission  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID PermissionID;
    private String PermissionName;
    private String Description;
}
