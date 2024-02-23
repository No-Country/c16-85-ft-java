package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.profession.ProfessionDetails;
import com.marketplace.models.valueobjets.profession.ProfessionTitle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "professions")
public class ProfessionalService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profession_title")
    @Embedded
    private ProfessionTitle title;

    @OneToOne(mappedBy = "profService")
    private ContractorProfile contractorProfile;

    @Embedded
    private ProfessionDetails details;

    private Double price;
    private boolean available;
    private boolean atHome;

    @OneToMany(mappedBy = "professionalService")
    private List<ServicesHistory> servicesHistoryList;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
