package com.marketplace.security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminDemoController {

    @GetMapping
    public ResponseEntity<String> findAll(){

        return ResponseEntity.ok("GET: /admin");

    }
    @GetMapping("/{id}")
    public ResponseEntity<String> find(){

        return ResponseEntity.ok("GET: /admin/{id}");
    }

    @PostMapping
    public ResponseEntity<String> save(){

        return ResponseEntity.ok("POST: /admin");

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(){

        return ResponseEntity.ok("PUT: /admin/{id}");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(){

        return ResponseEntity.ok("DELETE: /admin/{id}");

    }
}
