package com.marketplace.security.userauth.service;

import com.marketplace.exceptions.user.UserAccountNotFound;
import com.marketplace.models.mapper.IUserAuthMapper;
import com.marketplace.security.userauth.dto.DeleteUserRequest;
import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
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

        if(requestedUser.isPresent()){
            return IUserAuthMapper.INSTANCE.toResponse(requestedUser.get());
        }

        else{
            throw new UserAccountNotFound();
        }
    }

    //falta validacion de contrasenia vieja
    @Override
    public void updatePassword(UpdatePasswordRequest request,
                               Principal connectedUser) {

        //Assures User is authenticated
        var user = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if current password is correct
        if(!passwordEncoder.matches(request.currentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong password");//agregar excepcion personalizada
        }
        //check if the two new password are the same
        if(!request.newPassword().equals(request.confirmationPassword())){
            throw new IllegalStateException("Passwords are not the same");//agregar excepcion personalizada
        }

        //update password
        user.setPassword(passwordEncoder.encode(request.newPassword()));

        //update the new password
        repository.save(user);

    }

    //falta validacion de email viejo
    @Override
    public void updateEmail(UpdateUsernameRequest request){
        //Obtain current context security authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated())
            throw new IllegalStateException("User not authenticated");

        String currentUsername = authentication.getName();

        if(!request.currentUsername().equals(currentUsername)){
            throw new IllegalStateException("Current email does not match");
        }

        var requestedUser = repository.findByUsername(currentUsername);

        if(requestedUser.isPresent()){
            var user = requestedUser.get();
            //update email
            user.setUsername(request.newUsername());
            //update the new email
            repository.save(user);
        } else {
            throw new UserAccountNotFound();
        }

    }

    @Override
    public void updateEmail(UpdateUsernameRequest request, Principal connectedUser) {
        //Assures User is authenticated
        var user = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        //check if current password is correct
        if(!passwordEncoder.matches(request.password(), user.getPassword())){
            throw new IllegalStateException("Wrong password");//agregar excepcion personalizada
        }
        //check if current email is correct
        if(!request.currentUsername().equals( user.getUsername())){
            throw new IllegalStateException("Wrong email");//agregar excepcion personalizada
        }
        //check if the two new email are the same
        if(!request.newUsername().equals(request.confirmUsername())){
            throw new IllegalStateException("Emails are not the same");//agregar excepcion personalizada
        }

        //update email
        user.setUsername(request.newUsername());

        //update the new email
        repository.save(user);
    }

    //changeMailAndPassword

    //delete user
    @Override
    public void delete(DeleteUserRequest request, Principal connectedUser){

        var userAuth = (UserAuth) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if(!passwordEncoder.matches(request.password(), (userAuth.getPassword()))){
            throw new IllegalStateException("Wrong password"); //agregar excepcion personalizada
        }

        var user = repository.findByUsername(userAuth.getUsername());

        if(user.isPresent()){
            repository.deleteById(userAuth.getId());
        }

    }

}

