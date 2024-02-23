package com.marketplace.security.auth.service;

import com.marketplace.security.auth.dto.AuthenticationRequest;
import com.marketplace.security.auth.dto.AuthenticationResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserAuthRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

        var user = UserAuth.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        try{
            repository.save(user);

            var jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User Registered Successfully")
                    .statusCode(200)
                    .build();

        }catch(DataIntegrityViolationException e){

            return AuthenticationResponse.builder()
                    .token("")
                    .message("User Already Exists")
                    .statusCode(409)
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

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
    }
}
