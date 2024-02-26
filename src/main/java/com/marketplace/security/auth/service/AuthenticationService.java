package com.marketplace.security.auth.service;

import com.marketplace.exceptions.user.DuplicatedUserException;
import com.marketplace.exceptions.user.InvalidEmailException;
import com.marketplace.security.auth.dto.AuthenticationRequest;
import com.marketplace.security.auth.dto.AuthenticationResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.repository.UserAuthRepository;

import com.marketplace.service.impl.UserAccountServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.marketplace.security.userauth.model.Role.USER;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserAuthRepository userAuthRepository;
    private final UserAccountServiceImpl userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userRegister(RegisterRequest request) {

        //Email Validation (add request validation)
        try{
            validateEmail(request.getUsername());

        }catch(InvalidEmailException e){

            return AuthenticationResponse.builder()
                    .token("")
                    .message(e.getMessage())
                    .statusCode(400)
                    .build();
        }

        //UserAuth and UserAccount creation and persistence
        try{

            var userAuth = UserAuth.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(USER)
                    .build();

            userAuthRepository.save(userAuth);

            var userAccount = userAccountService.save(request, userAuth);

            userAuth.setUserAccount(userAccount);

            userAuthRepository.save(userAuth);

            var jwtToken = jwtService.generateToken(userAuth);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User Registered Successfully")
                    .statusCode(200)
                    .build();

        }catch(DataAccessException e){

            return AuthenticationResponse.builder()
                    .token("N/A")
                    .message("User Already Exists")
                    .statusCode(400)
                    .build();
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

        var user = userAuthRepository.findByUsername(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public void delete(Long id){


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