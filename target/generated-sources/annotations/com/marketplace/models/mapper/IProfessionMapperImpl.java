package com.marketplace.models.mapper;

import com.marketplace.DTO.contractor.ContractorProfileResponse;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.DTO.profession.ProfessionSaveRequest;
import com.marketplace.DTO.profession.ProfessionUpdateRequest;
import com.marketplace.models.entity.Category;
import com.marketplace.models.entity.ContractorProfile;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.valueobjets.contractor.BusinessName;
import com.marketplace.models.valueobjets.contractor.CeoLastName;
import com.marketplace.models.valueobjets.contractor.CeoName;
import com.marketplace.models.valueobjets.profession.ProfessionDetails;
import com.marketplace.models.valueobjets.profession.ProfessionTitle;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-29T19:34:39-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class IProfessionMapperImpl implements IProfessionMapper {

    @Override
    public ProfessionalService saveDtoToEntity(ProfessionSaveRequest request) {
        if ( request == null ) {
            return null;
        }

        ProfessionalService.ProfessionalServiceBuilder professionalService = ProfessionalService.builder();

        professionalService.title( professionSaveRequestToProfessionTitle( request ) );
        professionalService.details( professionSaveRequestToProfessionDetails( request ) );
        professionalService.category( professionSaveRequestToCategory( request ) );
        professionalService.contractorProfile( professionSaveRequestToContractorProfile( request ) );
        professionalService.price( request.getPrice() );
        professionalService.atHome( request.isAtHome() );

        return professionalService.build();
    }

    @Override
    public ProfessionalService updateDtoToEntity(ProfessionUpdateRequest request) {
        if ( request == null ) {
            return null;
        }

        ProfessionalService.ProfessionalServiceBuilder professionalService = ProfessionalService.builder();

        professionalService.title( professionUpdateRequestToProfessionTitle( request ) );
        professionalService.details( professionUpdateRequestToProfessionDetails( request ) );
        professionalService.category( professionUpdateRequestToCategory( request ) );
        professionalService.id( request.getId() );
        professionalService.price( request.getPrice() );
        professionalService.available( request.isAvailable() );
        professionalService.atHome( request.isAtHome() );

        return professionalService.build();
    }

    @Override
    public ProfessionResponse toDto(ProfessionalService professionalService) {
        if ( professionalService == null ) {
            return null;
        }

        ProfessionResponse professionResponse = new ProfessionResponse();

        professionResponse.setContractorProfile( contractorProfileToContractorProfileResponse( professionalService.getContractorProfile() ) );
        professionResponse.setTitle( professionalServiceTitleTitle( professionalService ) );
        professionResponse.setDetails( professionalServiceDetailsDetails( professionalService ) );
        professionResponse.setId( professionalService.getId() );
        professionResponse.setPrice( professionalService.getPrice() );
        professionResponse.setAvailable( professionalService.isAvailable() );
        professionResponse.setAtHome( professionalService.isAtHome() );
        professionResponse.setCategory( professionalService.getCategory() );

        return professionResponse;
    }

    protected ProfessionTitle professionSaveRequestToProfessionTitle(ProfessionSaveRequest professionSaveRequest) {
        if ( professionSaveRequest == null ) {
            return null;
        }

        String title = null;

        title = professionSaveRequest.getTitle();

        ProfessionTitle professionTitle = new ProfessionTitle( title );

        return professionTitle;
    }

    protected ProfessionDetails professionSaveRequestToProfessionDetails(ProfessionSaveRequest professionSaveRequest) {
        if ( professionSaveRequest == null ) {
            return null;
        }

        String details = null;

        details = professionSaveRequest.getDetails();

        ProfessionDetails professionDetails = new ProfessionDetails( details );

        return professionDetails;
    }

    protected Category professionSaveRequestToCategory(ProfessionSaveRequest professionSaveRequest) {
        if ( professionSaveRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( professionSaveRequest.getCategoryId() );

        return category.build();
    }

    protected ContractorProfile professionSaveRequestToContractorProfile(ProfessionSaveRequest professionSaveRequest) {
        if ( professionSaveRequest == null ) {
            return null;
        }

        ContractorProfile contractorProfile = new ContractorProfile();

        contractorProfile.setId( professionSaveRequest.getContractorProfileId() );

        return contractorProfile;
    }

    protected ProfessionTitle professionUpdateRequestToProfessionTitle(ProfessionUpdateRequest professionUpdateRequest) {
        if ( professionUpdateRequest == null ) {
            return null;
        }

        String title = null;

        title = professionUpdateRequest.getTitle();

        ProfessionTitle professionTitle = new ProfessionTitle( title );

        return professionTitle;
    }

    protected ProfessionDetails professionUpdateRequestToProfessionDetails(ProfessionUpdateRequest professionUpdateRequest) {
        if ( professionUpdateRequest == null ) {
            return null;
        }

        String details = null;

        details = professionUpdateRequest.getDetails();

        ProfessionDetails professionDetails = new ProfessionDetails( details );

        return professionDetails;
    }

    protected Category professionUpdateRequestToCategory(ProfessionUpdateRequest professionUpdateRequest) {
        if ( professionUpdateRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( professionUpdateRequest.getCategoryId() );

        return category.build();
    }

    private String contractorProfileBusinessNameBusinessName(ContractorProfile contractorProfile) {
        if ( contractorProfile == null ) {
            return null;
        }
        BusinessName businessName = contractorProfile.getBusinessName();
        if ( businessName == null ) {
            return null;
        }
        String businessName1 = businessName.businessName();
        if ( businessName1 == null ) {
            return null;
        }
        return businessName1;
    }

    private String contractorProfileCeoNameName(ContractorProfile contractorProfile) {
        if ( contractorProfile == null ) {
            return null;
        }
        CeoName ceoName = contractorProfile.getCeoName();
        if ( ceoName == null ) {
            return null;
        }
        String name = ceoName.name();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String contractorProfileCeoLastNameLastName(ContractorProfile contractorProfile) {
        if ( contractorProfile == null ) {
            return null;
        }
        CeoLastName ceoLastName = contractorProfile.getCeoLastName();
        if ( ceoLastName == null ) {
            return null;
        }
        String lastName = ceoLastName.lastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected ContractorProfileResponse contractorProfileToContractorProfileResponse(ContractorProfile contractorProfile) {
        if ( contractorProfile == null ) {
            return null;
        }

        String businessName = null;
        String ceoName = null;
        String ceoLastName = null;

        businessName = contractorProfileBusinessNameBusinessName( contractorProfile );
        ceoName = contractorProfileCeoNameName( contractorProfile );
        ceoLastName = contractorProfileCeoLastNameLastName( contractorProfile );

        ContractorProfileResponse contractorProfileResponse = new ContractorProfileResponse( businessName, ceoName, ceoLastName );

        return contractorProfileResponse;
    }

    private String professionalServiceTitleTitle(ProfessionalService professionalService) {
        if ( professionalService == null ) {
            return null;
        }
        ProfessionTitle title = professionalService.getTitle();
        if ( title == null ) {
            return null;
        }
        String title1 = title.title();
        if ( title1 == null ) {
            return null;
        }
        return title1;
    }

    private String professionalServiceDetailsDetails(ProfessionalService professionalService) {
        if ( professionalService == null ) {
            return null;
        }
        ProfessionDetails details = professionalService.getDetails();
        if ( details == null ) {
            return null;
        }
        String details1 = details.details();
        if ( details1 == null ) {
            return null;
        }
        return details1;
    }
}
