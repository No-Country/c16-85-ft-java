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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID serviceHistoryId;

    @Column
    @NotNull
    private LocalDate date;
    private BigDecimal price;

    @ManyToOne
    private ContractorProfile contractorProfile;

    @ManyToOne
    private Review review;

    @ManyToOne
    private CostumerContractor costumerContractor;

    @ManyToOne
    private Profession profesionalService;

}
