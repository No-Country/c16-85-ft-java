package com.marketplace.models.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
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

    @OneToOne
    private Review review;

    @ManyToOne
    @JoinColumn(name = "professional_service_id")
    private ProfessionalService professionalService;

}
