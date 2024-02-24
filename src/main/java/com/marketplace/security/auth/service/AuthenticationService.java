package com.marketplace.security.auth.service;

import com.marketplace.exceptions.user.InvalidEmailException;
import com.marketplace.security.auth.dto.AuthenticationRequest;
import com.marketplace.security.auth.dto.AuthenticationResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import com.marketplace.repository.IUserAccountRepository;
import com.marketplace.service.impl.UserAccountServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
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
    private final IUserAccountRepository userAccountRepository;
    private final UserAccountServiceImpl userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userRegister(RegisterRequest request) {

        try{
            validateEmail(request.getUsername());


        }catch(InvalidEmailException e){

            return AuthenticationResponse.builder()
                    .token("")
                    .message(e.getMessage())
                    .statusCode(400)
                    .build();
        }


        var userAuth = UserAuth.builder()
                .email(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(USER)
                .build();

        try{
            userAuthRepository.save(userAuth);
            //implementar vinculacion de cuentas
            userAccountService.save(request);

            var jwtToken = jwtService.generateToken(userAuth);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .message("User Registered Successfully")
                    .statusCode(200)
                    .build();

        }catch(DataIntegrityViolationException e){

            //throw new DuplicatedUserException();
            return AuthenticationResponse.builder()
                    .token("")
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

        var user = userAuthRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
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


