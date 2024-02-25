package com.marketplace.service;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProfessionService {

    Page<ProfessionResponse> findAll(Pageable pageable);

    ProfessionResponse findById(Long id);

    void save(ProfessionSaveRequest profession);

    void update(Long id, ProfessionUpdateRequest professionUpdateRequest);

    void deleteById(Long id);

}
