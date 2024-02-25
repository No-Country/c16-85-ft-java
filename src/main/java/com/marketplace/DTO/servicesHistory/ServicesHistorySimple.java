package com.marketplace.DTO.servicesHistory;

import com.marketplace.models.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesHistorySimple {

    /** Este DTO no devuelve relaciones con otras entidades. */

    private Long serviceHistoryId;
    private LocalDate date;
    private BigDecimal price;
    private Review review;

}
