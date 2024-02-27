package com.marketplace.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketplace.models.valueobjets.address.Address;
import jakarta.persistence.*;
import lombok.*;



@Entity(name = "locations")
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;


    private final String city ="Mar del Plata";
    private final String province ="Buenos Aires";
    private final String country = "Argentina";
    private final String coordinates=null;

    @Embedded
    private Address address;

    @OneToOne
    @JsonIgnore
    private ContractorProfile contractorProfile;

    @OneToOne
    private UserAccount userAccount;

    public Location(){}

    public Location( Address address, ContractorProfile contractorProfile, UserAccount userAccount) {
        this.address = address;
        this.contractorProfile = contractorProfile;
        this.userAccount = userAccount;
    }

    public static Location createLocation (ContractorProfile contractorProfile, String address, UserAccount userAccount){
        var newAddress = new Address(address);
        var newUserAccount = new UserAccount();
        return new Location(newAddress,contractorProfile,newUserAccount);
    }
}
