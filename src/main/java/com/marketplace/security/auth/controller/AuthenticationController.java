package com.marketplace.security.auth.controller;

import com.marketplace.security.auth.service.AuthenticationServiceImpl;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.auth.dto.AuthenticationRequest;
import com.marketplace.security.auth.dto.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> userRegister(
            @RequestBody RegisterRequest request
    ) {
        AuthenticationResponse response = service.userRegister(request);

        return ResponseEntity.ok(response);

    }

    //ubicacion temporal del metodo
    @PostMapping("/admin/register")
    public ResponseEntity<AuthenticationResponse> adminRegister(
            @RequestBody RegisterRequest request
    ) {
        AuthenticationResponse response = service.adminRegister(request);

        return ResponseEntity.ok(response);

    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {

        return ResponseEntity.ok(service.authenticate(request));

    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        service.refreshToken(request, response);
    }


}