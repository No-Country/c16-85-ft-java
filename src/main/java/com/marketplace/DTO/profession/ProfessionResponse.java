package com.marketplace.DTO.profession;

import com.marketplace.models.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ProfessionResponse {

    private UUID id;
    private String title;
    private Long price;
    private String details;
    private Category category;

}
