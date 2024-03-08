package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity(name = "locations")
@Setter
@Getter
@EqualsAndHashCode
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String city;
    private String province;
    private String country;
    private String coordinates;
    @Embedded
    private Address address;
    @OneToOne
    private UserAccount userAccount;
    @OneToOne
    @JsonIgnore
    private ContractorProfile contractorProfile;


}
