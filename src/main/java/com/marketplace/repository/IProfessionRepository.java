package com.marketplace.repository;

import com.marketplace.models.entity.ProfessionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProfessionRepository extends JpaRepository<ProfessionalService, Long> {

    Page<ProfessionalService> findByCategoryNameAndAvailableIsTrue(Pageable pageable, String categoryName);

    Page<ProfessionalService> findAllByAvailableIsTrue(Pageable pageable);

    Page<ProfessionalService> findByTitleTitleContainingAndAvailableIsTrue(Pageable pageable, String keyword);

    Page<ProfessionalService> findByContractorProfileIdAndAvailableIsTrue(Pageable pageable, Long id);

}
