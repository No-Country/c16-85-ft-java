package com.marketplace.DTO.profession;

import com.marketplace.models.entity.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProfessionRequest {

    private String title;
    private Long price;
    private String details;
    private Long categoryId;
    private Availability availability;

}
