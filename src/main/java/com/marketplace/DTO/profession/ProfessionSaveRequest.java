package com.marketplace.DTO.profession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProfessionSaveRequest {

    /** DTO para CREAR ProfessionalServices */

    private String title;
    private Double price;
    private String details;
    private boolean atHome;

    private Long contractorProfileId;
    private Long categoryId;

}
