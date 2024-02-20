package com.marketplace.models.entity;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.models.valueobjets.contractor.BusinessName;
import com.marketplace.models.valueobjets.contractor.CeoLastName;
import com.marketplace.models.valueobjets.contractor.CeoName;
import com.marketplace.utils.Available;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "ContractorProfiles")
@ToString
@EqualsAndHashCode
@Getter
public class ContractorProfile {

    @Id
    @GeneratedValue
    private Long id;
    private UserAccount userAccount;
    private ProfessionalService profService;
    private Location location;
    private List<ServicesHistory> servicesHistory;
    @Embedded
    private BusinessName businessName;
    @Embedded
    private CeoName ceoName;
    @Embedded
    private CeoLastName ceoLastName;
    @Enumerated(EnumType.STRING)
    private Available available;

    public ContractorProfile(){};
    public ContractorProfile(String businessName, String ceoName, String ceoLastName,UserAccount userAccount,
                             ProfessionalService profService, Location location, ServicesHistory servicesHistory){
        this.userAccount = userAccount;
        this.profService = profService;
        this.location = location;
        this.servicesHistory = servicesHistory;
        this.businessName = new BusinessName(businessName);
        this.ceoName = new CeoName(ceoName);
        this.ceoLastName = new CeoLastName(ceoLastName);
    }

    public static ContractorProfile createNewContractorProfile(ContractorProfileRequest contractorDetails,
                                                               UserAccount userAccount, ProfessionalService profService,
                                                               Location location, ServicesHistory servicesHistory){
        return new ContractorProfile(
                userAccount,
                profService,
                location,
                servicesHistory,
                contractorDetails.businessName(),
                contractorDetails.ceoName(),
                contractorDetails.ceoLastName()
        );
    }

}
