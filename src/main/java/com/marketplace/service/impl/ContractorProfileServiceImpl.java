package com.marketplace.service.impl;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.exceptions.TokenNotFoundException;
import com.marketplace.exceptions.contractor.ContractorNotFound;
import com.marketplace.models.entity.ContractorProfile;
import com.marketplace.models.entity.UserAccount;
import com.marketplace.models.mapper.contractor.ContractorMapper;
import com.marketplace.models.valueobjets.address.Address;
import com.marketplace.repository.ContractorProfileRepository;
import com.marketplace.repository.LocationRepository;
import com.marketplace.security.config.service.JwtService;
import com.marketplace.security.userauth.model.UserAuth;
import com.marketplace.security.userauth.model.valueobjects.Username;
import com.marketplace.security.userauth.repository.UserAuthRepository;
import com.marketplace.service.ContractorProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractorProfileServiceImpl implements ContractorProfileService {

    private final ContractorProfileRepository contractorRepository;
    private final ContractorMapper mapper;
    private final LocationRepository locationRepository;
    private final LocationServiceImpl locationService;
    private final JwtService jwtService;
    private final HttpServletRequest httpServletRequest;
    private final UserAuthRepository userAuthRepository;

    @Override
    public ContractorProfileResponse createContractorProfile(ContractorProfileRequest contractorDetails) {

        var newAddress = new Address(contractorDetails.address());
        var newLocation = locationService.createMarDelPlataLocation(newAddress);
        var getHeader = httpServletRequest.getHeader("Authorization");

        if(getHeader == null || !getHeader.startsWith("Bearer ")){
            throw new TokenNotFoundException("Token not found in the header request.");
        }

        var token = getHeader.substring(7);
        var username = jwtService.extractUsername(token);
        UserAuth findUserAuth = userAuthRepository.findByUsername(new Username(username))
                 .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        UserAccount userAccount = findUserAuth.getUserAccount();

        var newContractor = ContractorProfile.createNewContractorProfile(contractorDetails, userAccount ,newLocation);

        locationRepository.save(newLocation);
        contractorRepository.save(newContractor);

        return mapper.mapContractorToResponse(newContractor);
    }

    @Override
    public ContractorProfileResponse findContractorByID(Long id) {
        ContractorProfile findContractor = contractorRepository.findById(id)
                .orElseThrow(()-> new ContractorNotFound("Contractor not found with: " + id));

        return mapper.mapContractorToResponse(findContractor);
    }
}
