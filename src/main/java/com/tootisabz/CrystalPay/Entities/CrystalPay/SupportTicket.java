package com.tootisabz.CrystalPay.Entities.CrystalPay;

import com.tootisabz.CrystalPay.Common.Enums.TicketPriority;
import com.tootisabz.CrystalPay.Common.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project")
public class SupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID SupportTicketID;
    private UUID UserID;
    private String IssueDescription;
    private TicketStatus Status;
    private TicketPriority Priority;
    private boolean IsVisible;
    private LocalDateTime CreatedOn;
    private UUID AssignedTo;
    private LocalDateTime ModifiedOn;
    private String Resolution;
    private String CustomerFeedback;

}
