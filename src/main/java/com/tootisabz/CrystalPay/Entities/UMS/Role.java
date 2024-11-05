package com.tootisabz.CrystalPay.Entities.UMS;

import com.tootisabz.CrystalPay.Entities.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;

import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "ums")
public class Role extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID RoleID;
    private String RoleName;
    private String Description;
}
