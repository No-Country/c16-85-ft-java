package com.marketplace.service.impl;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import com.marketplace.exceptions.TokenNotFoundException;
import com.marketplace.exceptions.category.CategoryNotFoundException;
import com.marketplace.exceptions.contractor.ContractorNotFound;
import com.marketplace.exceptions.profession.ProfessionTitleEx;
import com.marketplace.exceptions.profession.ProfessionUpdateEx;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.models.mapper.IProfessionMapper;
import com.marketplace.repository.ContractorProfileRepository;
import com.marketplace.repository.ICategoryRepository;
import com.marketplace.repository.IProfessionRepository;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.model.valueobjects.Username;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import com.marketplace.service.IProfessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements IProfessionService {

    private static final java.lang.String PROFESSION_NOT_FOUND = "Profession not found";
    private static final java.lang.String CONTRACTOR_NOT_FOUND = "Contractor not found";
    private static final java.lang.String CATEGORY_NOT_FOUND = "Category not found";
    private static final java.lang.String PROFESSION_UPDATE_ERROR = "Error al actualizar, el ID del JSON no coincide con el del parámetro";

    private final IProfessionRepository professionRepository;

    private final ContractorProfileRepository contractorRepository;
    private final ICategoryRepository categoryRepository;
    private final UserAuthRepository userAuthRepository;
    private final JwtService jwtService;
    private final HttpServletRequest httpServletRequest;

    @Override
    public Page<ProfessionResponse> findAll(Pageable pageable) {
        return professionRepository
                .findAll(pageable)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public Page<ProfessionResponse> findAllAvailable(Pageable pageable) {
        return professionRepository
                .findAllByAvailableIsTrue(pageable)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public ProfessionResponse findById(Long id) {
        return IProfessionMapper.INSTANCE.toDto(professionRepository.findById(id)
                .orElseThrow(() -> new ProfessionTitleEx(PROFESSION_NOT_FOUND)));
    }

    @Override
    public Page<ProfessionResponse> findByCategoryName(Pageable pageable, java.lang.String categoryName) {
        return professionRepository
                .findByCategoryNameAndAvailableIsTrue(pageable, categoryName)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public Page<ProfessionResponse> findByTitle(Pageable pageable, java.lang.String keyword) {
        return professionRepository
                .findByTitleTitleContainingAndAvailableIsTrue(pageable, keyword)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public Page<ProfessionResponse> findByContractorId(Pageable pageable, Long contractorId) {
        return professionRepository
                .findByContractorProfileIdAndAvailableIsTrue(pageable, contractorId)
                .map(IProfessionMapper.INSTANCE::toDto);
    }

    @Override
    public void save(ProfessionSaveRequest profession) {

        UserAccount userAccount = getUserAccountFromToken();

        try {
            ProfessionalService newProfessionalService = IProfessionMapper.INSTANCE.saveDtoToEntity(profession);
            newProfessionalService.setContractorProfile(userAccount.getContractorProfile());
            newProfessionalService.setAvailable(true);

            professionRepository.save(newProfessionalService);

        } catch (DataIntegrityViolationException ex) {

            contractorRepository
                    .findById(userAccount.getContractorProfile().getId())
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

    /** Obtiene el UserAccount a través del username que llega en el token */
    private UserAccount getUserAccountFromToken(){

        var getHeader = httpServletRequest.getHeader("Authorization");

        if(getHeader == null || !getHeader.startsWith("Bearer ")){
            throw new TokenNotFoundException("Token not found in the header request.");
        }

        var token = getHeader.substring(7);
        var username = jwtService.extractUsername(token);
        UserAuth findUserAuth = userAuthRepository.findByUsername(new Username(username))
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return findUserAuth.getUserAccount();
    }

}
