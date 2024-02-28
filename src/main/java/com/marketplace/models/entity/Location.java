package com.marketplace.models.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "locations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private String city;
    private String country;
    @OneToOne
    private ContractorProfile contractorProfile;

}
