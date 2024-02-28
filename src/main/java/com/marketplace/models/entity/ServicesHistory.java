package com.marketplace.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "service_histories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesHistory {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "contractor_profile_id")
    private ContractorProfile contractorProfile;

    @OneToOne
    private Review review;

    @ManyToOne
    @JoinColumn(name = "professional_service_id")
    private ProfessionalService professionalService;

}
