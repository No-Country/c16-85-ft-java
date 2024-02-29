package com.marketplace.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "service_histories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceHistoryId;
    private LocalDate date;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "contractor_profile_id")
    private ContractorProfile contractorProfile;
    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "professional_service_id")
    private ProfessionalService professionalService;


}
