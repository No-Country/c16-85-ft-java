package com.marketplace.models.mapper;

import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.valueobjets.contractor.BusinessName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IProfessionMapper {

    IProfessionMapper INSTANCE = Mappers.getMapper(IProfessionMapper.class);

    /** Este sirve para mapear cuando se CREA un nuevo ProfessionalService */
    @Mapping(source = "title", target = "title.title")
    @Mapping(source = "details", target = "details.details")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "contractorProfileId", target = "contractorProfile.id")
    ProfessionalService saveDtoToEntity(ProfessionSaveRequest request);

    /** Este sirve para mapear cuando se ACTUALIZA un ProfessionalService existente */
    @Mapping(source = "title", target = "title.title")
    @Mapping(source = "details", target = "details.details")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "contractorProfileId", target = "contractorProfile.id")
    ProfessionalService updateDtoToEntity(ProfessionUpdateRequest request);

    /** Este sirve para devolver los DTO en las respuestas */
    @Mapping(source = "title.title", target = "title")
    @Mapping(source = "details.details", target = "details")
    @Mapping(source = "contractorProfile.businessName.businessName", target = "contractorProfile.businessName")
    @Mapping(source = "contractorProfile.ceoName.name", target = "contractorProfile.ceoName")
    @Mapping(source = "contractorProfile.ceoLastName.lastName", target = "contractorProfile.ceoLastName")
    ProfessionResponse toDto(ProfessionalService professionalService);

}
