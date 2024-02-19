package com.marketplace.service;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IProfessionService {

    Page<ProfessionResponse> findAll(Pageable pageable);

    ProfessionResponse findByUUID(UUID id);

    void save(ProfessionRequest profession);

    void update(UUID id, ProfessionRequest professionRequest);

    void deleteByUUID(UUID id);

}
