package com.marketplace.service.impl;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.repository.ContractorProfileRepository;
import com.marketplace.service.ContractorProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractorProfileServiceImpl implements ContractorProfileService {
    private final ContractorProfileRepository repository;

    @Override
    public ContractorProfileResponse createContractorProfile(ContractorProfileRequest contractorDetails) {
        return null;
    }
}
