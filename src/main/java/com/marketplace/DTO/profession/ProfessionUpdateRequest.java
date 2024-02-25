package com.marketplace.DTO.profession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionUpdateRequest {

    /** DTO para EDITAR ProfessionalServices */

    private String title;
    private Double price;
    private String details;
    private boolean atHome;
    private boolean available;
    private Long contractorProfileId;
    private Long categoryId;

}
