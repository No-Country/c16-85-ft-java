package com.marketplace.service.impl;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import com.marketplace.exceptions.category.CategoryNotFoundException;
import com.marketplace.exceptions.contractor.ContractorNotFound;
import com.marketplace.exceptions.profession.ProfessionTitleEx;
import com.marketplace.exceptions.profession.ProfessionUpdateEx;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.mapper.IProfessionMapper;
import com.marketplace.repository.ContractorProfileRepository;
import com.marketplace.repository.ICategoryRepository;
import com.marketplace.repository.IProfessionRepository;
import com.marketplace.service.ContractorProfileService;
import com.marketplace.service.IProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements IProfessionService {

    private static final String PROFESSION_NOT_FOUND = "Profession not found";
    private static final String CONTRACTOR_NOT_FOUND = "Contractor not found";
    private static final String CATEGORY_NOT_FOUND = "Category not found";
    private static final String PROFESSION_UPDATE_ERROR = "Error al actualizar, el ID del JSON no coincide con el del parámetro";

    private final IProfessionRepository professionRepository;

    private final ContractorProfileRepository contractorRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Page<ProfessionResponse> findAll(Pageable pageable) {
        return professionRepository.findAll(pageable).map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public ProfessionResponse findById(Long id) {
        return IProfessionMapper.INSTANCE.toDto(professionRepository.findById(id)
                .orElseThrow(() -> new ProfessionTitleEx(PROFESSION_NOT_FOUND)));
    }

    @Override
    public Page<ProfessionResponse> findByCategoryName(Pageable pageable, String categoryName) {
        return professionRepository
                .findByCategoryName(pageable, categoryName)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public Page<ProfessionResponse> findByTitle(Pageable pageable, String keyword) {
        return professionRepository
                .findByTitleTitleContaining(pageable, keyword)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public Page<ProfessionResponse> findByContractorId(Pageable pageable, Long contractorId) {
        return professionRepository
                .findByContractorProfileId(pageable, contractorId)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public void save(ProfessionSaveRequest profession) {
        try {
            ProfessionalService newProfessionalService = IProfessionMapper.INSTANCE.saveDtoToEntity(profession);

            newProfessionalService.setAvailable(true);
            professionRepository.save(newProfessionalService);

        } catch (DataIntegrityViolationException ex) {

            contractorRepository
                    .findById(profession.getContractorProfileId())
                    .orElseThrow(() -> new ContractorNotFound(CONTRACTOR_NOT_FOUND));
            categoryRepository
                    .findById(profession.getCategoryId())
                    .orElseThrow(() -> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
        }
    }

    @Override
    public void update(Long id, ProfessionUpdateRequest professionUpdateRequest) {

        // Comparar el ID que llega por parámetro con el del JSON recibido
        if (!id.equals(professionUpdateRequest.getId())) {
            throw new ProfessionUpdateEx(PROFESSION_UPDATE_ERROR);
        }

        // Obtengo el ProfessionalService de la BD
        ProfessionalService professionalDB = professionRepository.findById(id)
                .orElseThrow(() -> new ProfessionTitleEx(PROFESSION_NOT_FOUND));

        // Mapeo el DTO a entidad
        ProfessionalService professionalServiceUpdated = IProfessionMapper
                .INSTANCE.updateDtoToEntity(professionUpdateRequest);

        // Asigno los valores que faltan en el DTO y que no son modificables
        professionalServiceUpdated.setId(id);
        professionalServiceUpdated.setContractorProfile(professionalDB.getContractorProfile());

        professionRepository.save(professionalServiceUpdated);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        professionRepository.deleteById(id);
    }

}
