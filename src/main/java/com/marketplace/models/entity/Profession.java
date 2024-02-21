package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.profession.ProfessionDetails;
import com.marketplace.models.valueobjets.profession.ProfessionTitle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(name = "professions")
public class Profession {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "profession_title")
    @Embedded
    private ProfessionTitle title;

    @Column(nullable = false)
    private Long price;

    @Embedded
    private ProfessionDetails details;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
