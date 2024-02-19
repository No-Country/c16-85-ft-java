package com.marketplace.models.valueobjets.profession;

import com.marketplace.exceptions.profession.ProfessionTitleEx;
import jakarta.persistence.Embeddable;

@Embeddable
public record ProfessionDetails(String details) {

    private static final String INVALID_NAME = "Invalid name";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 255;

    public ProfessionDetails {
        validateDetails(details);
    }

    public static void validateDetails(String details){
        if (details == null || details.length() < MIN_LENGTH || details.length() > MAX_LENGTH){
            throw new ProfessionTitleEx(INVALID_NAME);
        }
    }

}
