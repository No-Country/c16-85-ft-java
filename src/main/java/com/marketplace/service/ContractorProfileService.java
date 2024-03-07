package com.marketplace.service;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;

import java.util.List;

public interface ContractorProfileService {
    ContractorProfileResponse createContractorProfile(ContractorProfileRequest contractorDetails);

    ContractorProfileResponse findContractorByID(Long id);

    List<ContractorProfileResponse> findAllContractors();
}
