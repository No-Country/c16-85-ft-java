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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UserAccount userAccount;
    private ProfessionalService profService;
    @OneToOne
    private Location location;
    private final List<ServicesHistory> servicesHistory = new ArrayList<>();
    @Embedded
    private BusinessName businessName;
    @Embedded
    private CeoName ceoName;
    @Embedded
    private CeoLastName ceoLastName;
    @Enumerated(EnumType.STRING)
    private Available available;

    public ContractorProfile(){}
    public ContractorProfile(UserAccount userAccount, ProfessionalService profService,
                             Location location, BusinessName businessName, CeoName ceoName,
                             CeoLastName ceoLastName, Available available){
        this.userAccount = userAccount;
        this.profService = profService;
        this.location = location;
        this.businessName = businessName;
        this.ceoName = ceoName;
        this.ceoLastName = ceoLastName;
        this.available = available;
    }

    public static ContractorProfile createNewContractorProfile(ContractorProfileRequest contractorDetails,
                                                               UserAccount userAccount,
                                                               ProfessionalService profService,
                                                               Location location){
        var businessName = new BusinessName(contractorDetails.businessName());
        var ceoName = new CeoName(contractorDetails.ceoName());
        var ceoLastName = new CeoLastName(contractorDetails.ceoLastName());
        var available = Available.YES;

        return new ContractorProfile(userAccount, profService, location,
                businessName, ceoName, ceoLastName, available);
    }

    public void addServicesHistory(ServicesHistory servicesHistory) {
        this.servicesHistory.add(servicesHistory);
    }

}
