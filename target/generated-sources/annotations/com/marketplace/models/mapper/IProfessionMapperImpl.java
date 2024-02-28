package com.marketplace.models.mapper;

import com.marketplace.DTO.profession.ProfessionRequest;
import com.marketplace.DTO.profession.ProfessionResponse;
import com.marketplace.models.entity.Category;
import com.marketplace.models.entity.ProfessionalService;
import com.marketplace.models.valueobjets.profession.ProfessionDetails;
import com.marketplace.models.valueobjets.profession.ProfessionTitle;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T13:06:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Private Build)"
)
public class IProfessionMapperImpl implements IProfessionMapper {

    @Override
    public ProfessionalService toEntity(ProfessionRequest request) {
        if ( request == null ) {
            return null;
        }

        ProfessionalService.ProfessionalServiceBuilder professionalService = ProfessionalService.builder();

        professionalService.title( professionRequestToProfessionTitle( request ) );
        professionalService.details( professionRequestToProfessionDetails( request ) );
        professionalService.category( professionRequestToCategory( request ) );
        professionalService.price( request.getPrice() );
        professionalService.atHome( request.isAtHome() );

        return professionalService.build();
    }

    @Override
    public ProfessionResponse toDto(ProfessionalService professionalService) {
        if ( professionalService == null ) {
            return null;
        }

        ProfessionResponse professionResponse = new ProfessionResponse();

        professionResponse.setTitle( professionalServiceTitleTitle( professionalService ) );
        professionResponse.setDetails( professionalServiceDetailsDetails( professionalService ) );
        professionResponse.setId( professionalService.getId() );
        professionResponse.setPrice( professionalService.getPrice() );
        professionResponse.setAvailable( professionalService.isAvailable() );
        professionResponse.setAtHome( professionalService.isAtHome() );
        professionResponse.setCategory( professionalService.getCategory() );

        return professionResponse;
    }

    protected ProfessionTitle professionRequestToProfessionTitle(ProfessionRequest professionRequest) {
        if ( professionRequest == null ) {
            return null;
        }

        String title = null;

        title = professionRequest.getTitle();

        ProfessionTitle professionTitle = new ProfessionTitle( title );

        return professionTitle;
    }

    protected ProfessionDetails professionRequestToProfessionDetails(ProfessionRequest professionRequest) {
        if ( professionRequest == null ) {
            return null;
        }

        String details = null;

        details = professionRequest.getDetails();

        ProfessionDetails professionDetails = new ProfessionDetails( details );

        return professionDetails;
    }

    protected Category professionRequestToCategory(ProfessionRequest professionRequest) {
        if ( professionRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( professionRequest.getCategoryId() );

        return category.build();
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
