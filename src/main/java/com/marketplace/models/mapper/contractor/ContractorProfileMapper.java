package com.marketplace.models.mapper.contractor;

import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.models.entity.ContractorProfile;

public class ContractorProfileMapper {
    public ContractorProfileResponse mapContractorToResponse(ContractorProfile contractor) {
        return new ContractorProfileResponse(
                contractor.getBusinessName().businessName(),
                contractor.getCeoName().name(),
                contractor.getCeoLastName().lastName(),
                contractor.getLocation().getAddress().address()
        );
    }
}
