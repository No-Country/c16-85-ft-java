package com.marketplace.controller;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.service.impl.ContractorProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contractor")
public class ContractorProfileController {
    private final ContractorProfileServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<ContractorProfileResponse> createNewContractorProfile(ContractorProfileRequest contractorDetails){
        return ResponseEntity.ok(service.createContractorProfile(contractorDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractorProfileResponse> findContractorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findContractorByID(id));
    }
}
