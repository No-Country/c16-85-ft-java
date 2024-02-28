package com.marketplace.security.userauth.service;

import com.marketplace.security.userauth.dto.DeleteUserRequest;
import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public interface IUserAuthService {

    Page<UserAuthResponse> findAll(Pageable pageable);
    UserAuthResponse findById(Long id);

    void updatePassword(UpdatePasswordRequest request, Principal connectedUser);

    //falta validacion de email viejo
    void updateEmail(UpdateUsernameRequest request);

    void updateEmail(UpdateUsernameRequest request, Principal connectedUser);

    void delete(DeleteUserRequest request, Principal connectedUser);
}
