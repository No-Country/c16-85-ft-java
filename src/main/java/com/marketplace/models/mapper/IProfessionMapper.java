package com.marketplace.models.mapper;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.models.entity.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IProfessionMapper {

    IProfessionMapper INSTANCE = Mappers.getMapper(IProfessionMapper.class);

    @Mapping(source = "title", target = "title.title")
    @Mapping(source = "details", target = "details.details")
    @Mapping(source = "categoryId", target = "category.id")
    Profession toEntity(ProfessionRequest request);

    @Mapping(source = "title.title", target = "title")
    @Mapping(source = "details.details", target = "details")
    ProfessionResponse toDto(Profession profession);

}
