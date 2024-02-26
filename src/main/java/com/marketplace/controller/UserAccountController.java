package com.marketplace.controller;

import com.marketplace.DTO.useraccount.UserAccountResponse;
import com.marketplace.security.auth.dto.RegisterRequest;
import com.marketplace.security.auth.service.AuthenticationService;
import com.marketplace.service.IUserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAccountController {

    private final IUserAccountService service;
    private final AuthenticationService authService;

    @GetMapping
    public ResponseEntity<List<UserAccountResponse>> findAll(){

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserAccountResponse> findById(@PathVariable Long id){

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody RegisterRequest request){
        service.update(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        authService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
