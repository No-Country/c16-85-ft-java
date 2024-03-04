package com.marketplace.security.userauth.service;

import com.marketplace.exceptions.user.authenticationexceptions.*;
import com.marketplace.exceptions.user.UserAccountNotFound;
import com.marketplace.models.mapper.IUserAuthMapper;
import com.marketplace.security.userauth.dto.DeleteUserRequest;
import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.model.valueobjects.Username;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements IUserAuthService {

    private final UserAuthRepository repository;
    //private final UserAuthMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Page<UserAuthResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(IUserAuthMapper.INSTANCE::toResponse);
    }

    @Override
    public UserAuthResponse findById(Long id) {
        Optional<UserAuth> requestedUser = repository.findById(id);

        if(requestedUser.isPresent())
            return IUserAuthMapper.INSTANCE.toResponse(requestedUser.get());

        else
            throw new UserAccountNotFound();

    }

    //falta validacion de contrasenia vieja
    @Override
    public void updatePassword(UpdatePasswordRequest request,
                               Principal connectedUser) {

        //Assures User is authenticated
        var user = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if current password is correct
        if(!passwordEncoder.matches(request.currentPassword(), user.getPassword()))
            throw new InvalidPasswordException("Wrong password");//agregar excepcion personalizada

        //check if the two new password are the same
        if(!request.newPassword().equals(request.confirmationPassword()))
            throw new MismatchedPasswordException("New Password and confirmation are not the same");//agregar excepcion personalizada

        if(request.currentPassword().equals(request.newPassword()))
            throw new DuplicatedPasswordException("Old and new passwords could not be the same");

        //update password
        user.setPassword(passwordEncoder.encode(request.newPassword()));

        //update the new password
        repository.save(user);

    }
    //revisar refresh token
    @Override
    public void updateEmail(UpdateUsernameRequest request, Principal connectedUser) {
        //Assures User is authenticated
        var userAuth = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if current password is correct
        if(!passwordEncoder.matches(request.password(), userAuth.getPassword()))
            throw new InvalidPasswordException("Wrong password");

        //check if current email is correct
        if(!request.currentUsername().equals(userAuth.getUsername()))
            throw new InvalidEmailException("Wrong email");

        //check if the two new email are the same
        if(!request.newUsername().equals(request.confirmUsername()))
            throw new MismatchedEmailException("New email and confirmation email are not the same");

        if(request.currentUsername().equals(request.newUsername()))
            throw new DuplicatedEmailException("Old email and new email are repeated");

        if(repository.findByUsername(new Username(request.newUsername())).isPresent())
            throw new DuplicatedEmailException("New email already registered!");

        //update email
        userAuth.setUsername(new Username(request.newUsername()));

        //update the new email
        repository.save(userAuth);
    }

    //changeMailAndPassword

    //delete user
    @Override
    public void delete(DeleteUserRequest request, Principal connectedUser){

        var userAuth = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if(!passwordEncoder.matches(request.password(), (userAuth.getPassword())))
            throw new InvalidPasswordException("Wrong password");


        var user = repository.findByUsername(new Username(userAuth.getUsername()));

        if(user.isPresent())
            repository.deleteById(userAuth.getId());
        else
            throw new UserAccountNotFound();

    }

}