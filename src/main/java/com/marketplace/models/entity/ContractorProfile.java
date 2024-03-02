package com.marketplace.models.entity;

import com.marketplace.DTO.contractor.ContractorProfileRequest;
import com.marketplace.models.valueobjets.contractor.BusinessName;
import com.marketplace.models.valueobjets.contractor.CeoLastName;
import com.marketplace.models.valueobjets.contractor.CeoName;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ContractorProfiles")
@ToString
@EqualsAndHashCode
@Getter @Setter
public class ContractorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "contractorProfile")
    private final List<ProfessionalService> profService = new ArrayList<>();

    @OneToOne(mappedBy = "contractorProfile")
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "contractorProfile")
    private final List<ServicesHistory> servicesHistory = new ArrayList<>();

    @Embedded
    private BusinessName businessName;

    @Embedded
    private CeoName ceoName;

    @Embedded
    private CeoLastName ceoLastName;


    public ContractorProfile(){}
    public ContractorProfile(UserAccount userAccount, Location location, BusinessName businessName,
                             CeoName ceoName, CeoLastName ceoLastName){
        this.userAccount = userAccount;
        this.location = location;
        this.businessName = businessName;
        this.ceoName = ceoName;
        this.ceoLastName = ceoLastName;
    }

    public static ContractorProfile createNewContractorProfile(ContractorProfileRequest contractorDetails,
                                                               UserAccount userAccount,
                                                               Location location){
        var businessName = new BusinessName(contractorDetails.businessName());
        var ceoName = new CeoName(contractorDetails.ceoName());
        var ceoLastName = new CeoLastName(contractorDetails.ceoLastName());

        return new ContractorProfile(userAccount, location,
                businessName, ceoName, ceoLastName);
    }

    public void addServicesHistory(ServicesHistory servicesHistory) {
        this.servicesHistory.add(servicesHistory);
    }
    public void addProfessionalService(ProfessionalService profesionalService) {
        this.profService.add(profesionalService);
    }
}
