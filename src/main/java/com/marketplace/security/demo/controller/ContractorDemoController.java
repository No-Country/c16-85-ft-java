package com.marketplace.security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contractors")
public class ContractorDemoController {

    @GetMapping
    public ResponseEntity<String> findAll(){

        return ResponseEntity.ok("GET: /contractors");

    }
    @GetMapping("/{id}")
    public ResponseEntity<String> find(){

        return ResponseEntity.ok("GET: /contractors/{id}");
    }

    @PostMapping
    public ResponseEntity<String> save(){

        return ResponseEntity.ok("POST: /contractors");

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(){

        return ResponseEntity.ok("PUT: /contractors/{id}");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(){

        return ResponseEntity.ok("DELETE: /contractors/{id}");

    }
}
