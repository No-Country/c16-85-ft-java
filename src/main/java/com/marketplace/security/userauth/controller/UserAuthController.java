package com.marketplace.security.userauth.controller;

import com.marketplace.security.userauth.dto.UpdateUsernameRequest;
import com.marketplace.security.userauth.dto.UpdatePasswordRequest;
import com.marketplace.security.userauth.dto.DeleteUserRequest;
import com.marketplace.security.userauth.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class UserAuthController {
    private final UserAuthService service;

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
        service.updateEmail(request/*, connectedUser*/);

        return ResponseEntity.ok().build();

    }
//    @GetMapping
//    public ResponseEntity<String> findAll(){
//
//        return ResponseEntity.ok("GET: /admin");
//
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<String> findById(Long id){
//
//        return ResponseEntity.ok("GET: /admin/{id}");
//    }
//

    @DeleteMapping("users/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserRequest request,
                                    Principal connectedUser){

        service.delete(request, connectedUser);

        return ResponseEntity.noContent().build();

    }
}
