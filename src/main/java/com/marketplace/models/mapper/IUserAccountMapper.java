package com.marketplace.models.mapper;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.DTO.useraccount.UserAccountUpdateRequest;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.security.auth.dto.RegisterRequest;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IUserAccountMapper {

    IUserAccountMapper INSTANCE = Mappers.getMapper(IUserAccountMapper.class);


    @Mapping(source="firstname", target = "firstname.firstname")
    @Mapping(source="lastname", target = "lastname.lastname")
    @Mapping(source="birthday", target = "birthday.birthday")
    @Mapping(source="mobile", target = "mobile.mobile")
    @Mapping(target="username", ignore = true)
    @Mapping(target="location", ignore = true)
    @Mapping(target="contractorProfile", ignore = true)
    @Mapping(target="servicesHistory", ignore = true)
    @Mapping(target="photo", ignore = true)
    UserAccount toEntity(RegisterRequest request);

    @Mapping(source="firstname", target = "firstname.firstname")
    @Mapping(source="lastname", target = "lastname.lastname")
    @Mapping(source="birthday", target = "birthday.birthday")
    @Mapping(source="mobile", target = "mobile.mobile")
    @Mapping(source = "address", target="location.address")
    @Mapping(target="username", ignore = true)
    @Mapping(target="contractorProfile", ignore = true)
    @Mapping(target="servicesHistory", ignore = true)
    @Mapping(target="photo", ignore = true)
    UserAccount updateRequestToEntity(UserAccountUpdateRequest request);

    @Mapping(source="username", target = "username")
    @Mapping(source="firstname.firstname", target = "firstname")
    @Mapping(source="lastname.lastname", target = "lastname")
    @Mapping(target = "role", expression = "java(userAccount.getUserAuth().getRole().toString())")
    UserAccountResponse toUserResponse(UserAccount userAccount);

    List<UserAccountResponse>toUserResponseList(List<UserAccount> userAccounts);

}
