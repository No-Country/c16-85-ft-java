package com.marketplace.service;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import com.marketplace.models.entity.ProfessionalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProfessionService {

    Page<ProfessionResponse> findAll(Pageable pageable);

    ProfessionResponse findById(Long id);

    Page<ProfessionResponse> findByCategoryName(Pageable pageable, String categoryName);

    Page<ProfessionResponse> findByTitle(Pageable pageable, String keyword);

    Page<ProfessionResponse> findByContractorId(Pageable pageable, Long contractorId);

    void save(ProfessionSaveRequest profession);

    void update(Long id, ProfessionUpdateRequest professionUpdateRequest);

    void deleteById(Long id);

}
