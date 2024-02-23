package com.marketplace.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserDemoController {

    @GetMapping
    public ResponseEntity<String> findAll(){

        return ResponseEntity.ok("GET: /users");

    }
    @GetMapping("/{id}")
    public ResponseEntity<String> find(){

        return ResponseEntity.ok("GET: /users/{id}");
    }

    @PostMapping
    public ResponseEntity<String> save(){

        return ResponseEntity.ok("POST: /users");

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(){

        return ResponseEntity.ok("PUT: /users/{id}");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(){

        return ResponseEntity.ok("DELETE: /users/{id}");

    }

}
