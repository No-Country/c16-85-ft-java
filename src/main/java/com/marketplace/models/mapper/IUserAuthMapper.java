package com.marketplace.models.mapper;

import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.model.UserAuth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IUserAuthMapper {

    IUserAuthMapper INSTANCE = Mappers.getMapper(IUserAuthMapper.class);

    UserAuth toEntity(RegisterRequest request);
    @Mapping(target="id", source="id")
    @Mapping(target="username", source="username")
    UserAuthResponse toResponse(UserAuth userAuth);

    List<UserAuthResponse> toResponseList(List<UserAuth> userAuths);

}
