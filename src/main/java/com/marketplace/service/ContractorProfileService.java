package com.marketplace.service;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;

public interface ContractorProfileService {
    ContractorProfileResponse createContractorProfile(ContractorProfileRequest contractorDetails);
}
