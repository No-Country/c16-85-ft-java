package com.marketplace.DTO.profession;

import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.models.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor @NoArgsConstructor
public class ProfessionResponse {

    private Long id;
    private String title;
    private String details;
    private Double price;
    private boolean available;
    private boolean atHome;

    private ContractorProfileResponse contractorProfile;
    private Category category;

    /** ¿Debería devolver la lista? Ver cómo es la lógica en el frontend.
     * Se puede buscar la lista solo cuando sea necesario o devolver tod0 junto.
     * */
//     private List<ServicesHistorySimple> servicesHistory;

}
