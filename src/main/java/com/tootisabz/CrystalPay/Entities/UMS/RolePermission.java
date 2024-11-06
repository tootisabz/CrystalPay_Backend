package com.tootisabz.CrystalPay.Entities.UMS;

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
@Table(schema = "ums")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID rolePermissionID;

    @ManyToOne
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "PermissionID", referencedColumnName = "PermissionID")
    private Permission permission;
}
