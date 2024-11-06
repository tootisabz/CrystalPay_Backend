package com.tootisabz.CrystalPay.Entities.UMS;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "ums")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID NotificationID;
    private UUID UserID;
    private String Message;
    private Date NotificationDate;
    private String Status;
}
