package com.marketplace.DTO.profession;

import com.marketplace.models.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor
public class ProfessionResponse {

    private Long id;
    private String title;
    private String details;
    private Double price;
    private boolean available;
    private boolean atHome;
    private Category category;

}
