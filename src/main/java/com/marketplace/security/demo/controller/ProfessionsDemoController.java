package com.marketplace.security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profession")
public class ProfessionsDemoController {

    @GetMapping
    public ResponseEntity<String> findAll(){

        return ResponseEntity.ok("GET: /professions");

    }
    @GetMapping("/{id}")
    public ResponseEntity<String> find(){

        return ResponseEntity.ok("GET: /professions/{id}");
    }

    @PostMapping
    public ResponseEntity<String> save(){

        return ResponseEntity.ok("POST: /professions");

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(){

        return ResponseEntity.ok("PUT: /professions/{id}");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(){

        return ResponseEntity.ok("DELETE: /professions/{id}");

    }
}