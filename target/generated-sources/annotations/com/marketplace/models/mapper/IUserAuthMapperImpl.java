package com.marketplace.models.mapper;

import com.marketplace.models.entity.UserAccount;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.model.UserAuth;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T23:16:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class IUserAuthMapperImpl implements IUserAuthMapper {

    @Override
    public UserAuth toEntity(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserAuth.UserAuthBuilder userAuth = UserAuth.builder();

        userAuth.username( map( request.username() ) );
        userAuth.password( request.password() );

        return userAuth.build();
    }

    @Override
    public UserAuthResponse toResponse(UserAuth userAuth) {
        if ( userAuth == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String role = null;
        Long userAccountId = null;

        id = userAuth.getId();
        username = userAuth.getUsername();
        if ( userAuth.getRole() != null ) {
            role = userAuth.getRole().name();
        }
        userAccountId = userAuthUserAccountId( userAuth );

        UserAuthResponse userAuthResponse = new UserAuthResponse( id, username, role, userAccountId );

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

    private Long userAuthUserAccountId(UserAuth userAuth) {
        if ( userAuth == null ) {
            return null;
        }
        UserAccount userAccount = userAuth.getUserAccount();
        if ( userAccount == null ) {
            return null;
        }
        Long id = userAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
