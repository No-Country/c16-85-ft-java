package com.marketplace.security.userauth.service;

import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public interface UserAuthService {

    List<UserAuthResponse> findAll();
    UserAuthResponse findById(Long id);
    void update(Long id);

    void delete(Long id);

    void updatePassword(UpdatePasswordRequest request, Principal connectedUser);

    //falta validacion de email viejo
    void updateEmail(UpdateUsernameRequest request);

    void updateEmail(UpdateUsernameRequest request, Principal connectedUser);
}
