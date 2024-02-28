package com.marketplace.DTO.location;

import com.marketplace.models.entity.ContractorProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDTO {


    private Long locationId;

    private String city;
    private String country;

    private ContractorProfile contractorProfile;

}