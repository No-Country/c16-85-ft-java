package com.marketplace.models.mapper;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.models.valueobjets.useraccount.Birthday;
import com.marketplace.models.valueobjets.useraccount.Firstname;
import com.marketplace.models.valueobjets.useraccount.Lastname;
import com.marketplace.models.valueobjets.useraccount.Mobile;
import com.marketplace.security.auth.dto.RegisterRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T20:09:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class IUserAccountMapperImpl implements IUserAccountMapper {

    @Override
    public UserAccount toEntity(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        UserAccount.UserAccountBuilder userAccount = UserAccount.builder();

        userAccount.firstname( registerRequestToFirstname( request ) );
        userAccount.lastname( registerRequestToLastname( request ) );
        userAccount.birthday( registerRequestToBirthday( request ) );
        userAccount.mobile( registerRequestToMobile( request ) );

        return userAccount.build();
    }

    @Override
    public UserAccountResponse toUserResponse(UserAccount userAccount) {
        if ( userAccount == null ) {
            return null;
        }

        UserAccountResponse.UserAccountResponseBuilder userAccountResponse = UserAccountResponse.builder();

        userAccountResponse.username( userAccount.getUsername() );
        userAccountResponse.firstname( userAccountFirstnameFirstname( userAccount ) );
        userAccountResponse.lastname( userAccountLastnameLastname( userAccount ) );

        return userAccountResponse.build();
    }

    @Override
    public List<UserAccountResponse> toUserResponseList(List<UserAccount> userAccounts) {
        if ( userAccounts == null ) {
            return null;
        }

        List<UserAccountResponse> list = new ArrayList<UserAccountResponse>( userAccounts.size() );
        for ( UserAccount userAccount : userAccounts ) {
            list.add( toUserResponse( userAccount ) );
        }

        return list;
    }

    protected Firstname registerRequestToFirstname(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        String firstname = null;

        firstname = registerRequest.firstname();

        Firstname firstname1 = new Firstname( firstname );

        return firstname1;
    }

    protected Lastname registerRequestToLastname(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        String lastname = null;

        lastname = registerRequest.lastname();

        Lastname lastname1 = new Lastname( lastname );

        return lastname1;
    }

    protected Birthday registerRequestToBirthday(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        String birthday = null;

        birthday = registerRequest.birthday();

        Birthday birthday1 = new Birthday( birthday );

        return birthday1;
    }

    protected Mobile registerRequestToMobile(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        String mobile = null;

        mobile = registerRequest.mobile();

        Mobile mobile1 = new Mobile( mobile );

        return mobile1;
    }

    private String userAccountFirstnameFirstname(UserAccount userAccount) {
        if ( userAccount == null ) {
            return null;
        }
        Firstname firstname = userAccount.getFirstname();
        if ( firstname == null ) {
            return null;
        }
        String firstname1 = firstname.firstname();
        if ( firstname1 == null ) {
            return null;
        }
        return firstname1;
    }

    private String userAccountLastnameLastname(UserAccount userAccount) {
        if ( userAccount == null ) {
            return null;
        }
        Lastname lastname = userAccount.getLastname();
        if ( lastname == null ) {
            return null;
        }
        String lastname1 = lastname.lastname();
        if ( lastname1 == null ) {
            return null;
        }
        return lastname1;
    }
}
