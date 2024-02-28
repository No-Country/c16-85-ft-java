package com.marketplace.models.mapper;

import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.model.UserAuth;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T14:50:36-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class IUserAuthMapperImpl implements IUserAuthMapper {

    @Override
    public UserAuth toEntity(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserAuth.UserAuthBuilder userAuth = UserAuth.builder();

        userAuth.username( request.getUsername() );
        userAuth.password( request.getPassword() );

        return userAuth.build();
    }

    @Override
    public UserAuthResponse toResponse(UserAuth userAuth) {
        if ( userAuth == null ) {
            return null;
        }

        Long id = null;
        String username = null;

        id = userAuth.getId();
        username = userAuth.getUsername();

        UserAuthResponse userAuthResponse = new UserAuthResponse( id, username );

        return userAuthResponse;
    }

    @Override
    public List<UserAuthResponse> toResponseList(List<UserAuth> userAuths) {
        if ( userAuths == null ) {
            return null;
        }

        List<UserAuthResponse> list = new ArrayList<UserAuthResponse>( userAuths.size() );
        for ( UserAuth userAuth : userAuths ) {
            list.add( toResponse( userAuth ) );
        }

        return list;
    }
}
