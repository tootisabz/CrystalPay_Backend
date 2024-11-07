package com.tootisabz.CrystalPay.Entities.UMS;

import com.tootisabz.CrystalPay.Entities.AuditableEntity;
import com.tootisabz.CrystalPay.Entities.CrystalPay.*;
import com.tootisabz.CrystalPay.Entities.Lookups.Currencies;
import jakarta.persistence.*;
import lombok.*;
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

    @OneToMany(mappedBy = "SenderUser")
    private List<Transaction> IssuedTransactions;

    @OneToMany(mappedBy = "ReceiverUser")
    private List<Transaction> AcquiredTransactions;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<KYC> KYC;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<Notification> Notifications;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<NFCTransactions> NFCTransactions;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<Tokenization> tokenizations;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<AuditLog> AuditLogs;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<Card> cards;

    @OneToMany
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private List<WalletAccount> WalletAccounts;


    @ManyToMany
    @JoinTable(
            name = "user_currencies",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "CurrencyID")
    )
    private Set<Currencies> Currencies;

    @ManyToMany
    @JoinTable(
            name = "user_permission",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "PermissionID")
    )
    private Set<Permission> Permissions;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private Set<Role> Roles;

    @Lob
    @Column(name = "biometric_data", columnDefinition = "bytea")
    private Object BiometricData;


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