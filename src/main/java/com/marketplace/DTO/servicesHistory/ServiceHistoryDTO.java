package com.marketplace.DTO.servicesHistory;

import com.marketplace.models.entity.ContractorProfile;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceHistoryDTO {

    private Long serviceHistoryId;
    private LocalDate date;
    private BigDecimal price;
    private ContractorProfile contractorProfile;
    private Review review;
    private ProfessionalService professionalService;

}