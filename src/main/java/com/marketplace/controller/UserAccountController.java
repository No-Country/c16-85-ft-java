package com.marketplace.controller;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.DTO.useraccount.UserAccountUpdateRequest;
import com.marketplace.service.IUserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAccountController {

    private final IUserAccountService service;

    @GetMapping
    public ResponseEntity<Page<UserAccountResponse>> findAll(Pageable pageable){

        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponse> findById(@PathVariable Long id){

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

        @PatchMapping("/{id}")
        public ResponseEntity<Void> update(@PathVariable Long id,
                                           @RequestBody UserAccountUpdateRequest request
                                            ){
            service.update(id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    //metodos DELETE y UPDATE de username y password en security.controller.UserAuthController
    //@PatchMapping("users/change-password")
    //@PatchMapping("users/change-email")
    //@DeleteMapping("users/delete")

}
