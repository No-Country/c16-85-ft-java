package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.addres.Addres;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
