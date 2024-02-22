package com.marketplace.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "service_histories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesHistory {

    @Id
    @Column
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceHistoryId;

    @Column
    @NotNull
    private LocalDate date;
    private BigDecimal price;

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
