package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.addres.Addres;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column
    @NotNull
    private String city;
    private String country;

    @Embedded
    private Addres addres;

    @OneToOne
    private ContractorProfile contractorProfile;

}
