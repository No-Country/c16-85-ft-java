package com.marketplace.service.impl;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.models.entity.ContractorProfile;
import com.marketplace.models.entity.Location;
import com.marketplace.models.mapper.contractor.ContractorMapper;
import com.marketplace.repository.ContractorProfileRepository;
import com.marketplace.service.ContractorProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractorProfileServiceImpl implements ContractorProfileService {
    private final ContractorProfileRepository contractorRepository;
    private final ContractorMapper mapper;

    @Override
    public ContractorProfileResponse createContractorProfile(ContractorProfileRequest contractorDetails) {
        /*Location location = new Location();
        ContractorProfile newContractor = createContractorProfile(contractorDetails,location,);
        contractorRepository.save(newContractor);

        return mapper.mapContractorToResponse(newContractor);*/
        return null;
    }
}
