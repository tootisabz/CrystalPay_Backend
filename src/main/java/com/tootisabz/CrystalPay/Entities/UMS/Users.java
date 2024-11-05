package com.tootisabz.CrystalPay.Entities.UMS;

import com.tootisabz.CrystalPay.Entities.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IndexColumn;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(schema = "ums", indexes = {
//        @Index(name = "idx_username", columnList = "UserName"),
//        @Index(name = "idx_email", columnList = "Email", unique = true)
//})
@Table(schema = "ums")
public class Users extends AuditableEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID UserID;
    private String FirstName;
    private String LastName;
    private Date DateOfBirth;
    private String Gender;
    @OrderColumn
    private String Email;
    private String Phone;
    private String Address;
    @OrderColumn
    private String UserName;
    private String Password;
    private String PhotoPath;
    private boolean IsEnabled;
    @Column(nullable = true)
    private byte[] BiometricData;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.Password;
    }

    @Override
    public String getUsername() {
        return this.UserName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.IsEnabled;
    }
}