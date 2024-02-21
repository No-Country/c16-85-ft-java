package com.marketplace.service.impl;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.exceptions.profession.ProfessionTitleEx;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.mapper.IProfessionMapper;
import com.marketplace.repository.IProfessionRepository;
import com.marketplace.service.IProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements IProfessionService {

    private static final String PROFESSION_NOT_FOUND = "Profession not found";

    private final IProfessionRepository professionRepository;

    @Override
    public Page<ProfessionResponse> findAll(Pageable pageable) {
        return professionRepository.findAll(pageable).map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public ProfessionResponse findByUUID(UUID id) {
        return IProfessionMapper.INSTANCE.toDto(professionRepository.findById(id)
                .orElseThrow(()-> new ProfessionTitleEx(PROFESSION_NOT_FOUND)));
    }

    @Override
    public void save(ProfessionRequest profession) {
        ProfessionalService newProfessionalService = IProfessionMapper.INSTANCE.toEntity(profession);

        professionRepository.save(newProfessionalService);
    }

    @Override
    public void update(UUID id, ProfessionRequest professionRequest) {
        ProfessionalService professionalServiceDB = professionRepository.findById(id)
                .orElseThrow(()-> new ProfessionTitleEx(PROFESSION_NOT_FOUND));

        ProfessionalService professionalServiceUpdated = IProfessionMapper.INSTANCE.toEntity(professionRequest);
        professionalServiceUpdated.setId(id);
        professionRepository.save(professionalServiceUpdated);
    }

    @Override
    public void deleteByUUID(UUID id) {
        findByUUID(id);
        professionRepository.deleteById(id);
    }

}
