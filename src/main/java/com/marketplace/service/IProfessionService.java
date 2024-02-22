package com.marketplace.service;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProfessionService {

    Page<ProfessionResponse> findAll(Pageable pageable);

    ProfessionResponse findById(Long id);

    void save(ProfessionRequest profession);

    void update(Long id, ProfessionRequest professionRequest);

    void deleteById(Long id);

}
