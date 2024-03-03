package com.marketplace.security.auth.service;

import com.marketplace.exceptions.user.*;
import com.marketplace.exceptions.user.authenticationexceptions.InvalidEmailException;
import com.marketplace.security.auth.dto.AuthenticationRequest;
import com.marketplace.security.auth.dto.AuthenticationResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.model.valueobjects.Username;
import com.marketplace.security.userauth.repository.UserAuthRepository;

import com.marketplace.service.impl.UserAccountServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.marketplace.security.userauth.model.Role.ADMIN;
import static com.marketplace.security.userauth.model.Role.USER;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

    private final UserAuthRepository userAuthRepository;
    private final UserAccountServiceImpl userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userRegister(RegisterRequest request) {

        validateEmail(request.username());

        //UserAuth and UserAccount creation and persistence
        try{

            var userAuth = UserAuth.builder()
                    .username(new Username(request.username()))
                    .password(passwordEncoder.encode(request.password()))
                    .role(USER)
                    .build();

            userAuthRepository.save(userAuth);

            var userAccount = userAccountService.save(request, userAuth);

            userAuth.setUserAccount(userAccount);

            userAuthRepository.save(userAuth);

            var jwtToken = jwtService.generateToken(userAuth);

            return AuthenticationResponse.builder()
                    .username(userAuth.getUsername())
                    .role(String.valueOf(userAuth.getRole()))
                    .token(jwtToken)
                    .message("User Registered Successfully")
                    .build();

        }catch(DataAccessException e){
            throw new DuplicatedUserException("User Already Exists");
        }
    }

    //TEMPORAL - PRUEBAS
    public AuthenticationResponse adminRegister(RegisterRequest request) {

        validateEmail(request.username());

        //UserAuth and UserAccount creation and persistence
        try{

            var userAuth = UserAuth.builder()
                    .username(new Username(request.username()))
                    .password(passwordEncoder.encode(request.password()))
                    .role(ADMIN)
                    .build();

            userAuthRepository.save(userAuth);

            var userAccount = userAccountService.save(request, userAuth);

            userAuth.setUserAccount(userAccount);
            userAuthRepository.save(userAuth);
            var jwtToken = jwtService.generateToken(userAuth);

            return AuthenticationResponse.builder()
                    .username(userAuth.getUsername())
                    .role(String.valueOf(userAuth.getRole()))
                    .token(jwtToken)
                    .message("User Registered Successfully")
                    .build();

        }catch(DataAccessException e){
            throw new DuplicatedUserException("User Already Exists");
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()
                    )
            );

        }catch(BadCredentialsException ex){

            throw new IncorrectEmailOrPasswordException("Email or password are incorrect");
        }


        var user = userAuthRepository.findByUsername(new Username(request.username()))
                .orElseThrow(() -> new EmailNotFoundException("Email not found: " + request.username()));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .username(user.getUsername())
                .role(String.valueOf(user.getRole()))
                .token(jwtToken)
                .message("User Authenticated")
                .build();

    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
    }

    public void validateEmail(String email){

        final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.com$";
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailException("Invalid email format: " + email);
        }
    }
}