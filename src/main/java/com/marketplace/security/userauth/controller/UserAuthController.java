package com.marketplace.security.userauth.controller;

import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.DeleteUserRequest;
import com.marketplace.security.userauth.dto.UserAuthResponse;
import com.marketplace.security.userauth.service.IUserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class UserAuthController {
    private final IUserAuthService service;

    @GetMapping("admin/user-auths")
    public ResponseEntity<Page<UserAuthResponse>> findAll(Pageable pageable){

        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);

    }

    @GetMapping("admin/user-auths/{id}")
    public ResponseEntity<UserAuthResponse> findById(@PathVariable Long id){

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PatchMapping("users/change-password") ResponseEntity<?> changePassword(
           @RequestBody UpdatePasswordRequest request,
           Principal connectedUser
    ){
        service.updatePassword(request, connectedUser);

        return ResponseEntity.ok().build();

   }

    @PatchMapping("users/change-email") ResponseEntity<?> changeEmail(
            @RequestBody UpdateUsernameRequest request,
            Principal connectedUser
    ){
        service.updateEmail(request, connectedUser);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("users/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserRequest request,
                                    Principal connectedUser){

        service.delete(request, connectedUser);

        return ResponseEntity.noContent().build();

    }
}
