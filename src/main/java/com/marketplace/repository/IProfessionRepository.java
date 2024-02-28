package com.marketplace.repository;

import com.marketplace.models.entity.ProfessionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProfessionRepository extends JpaRepository<ProfessionalService, Long> {

    Page<ProfessionalService> findByCategoryName(Pageable pageable, String categoryName);

//    Page<ProfessionalService> buscar por titulo.

    Page<ProfessionalService> findByTitleTitleContaining(Pageable pageable, String keyword);

    Page<ProfessionalService> findByContractorProfileId(Pageable pageable, Long id);

}
