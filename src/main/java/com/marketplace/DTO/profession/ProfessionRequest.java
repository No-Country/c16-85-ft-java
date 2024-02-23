package com.marketplace.DTO.profession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProfessionRequest {

    private String title;
    private Double price;
    private String details;
    private boolean atHome;
    private Long categoryId;

}
