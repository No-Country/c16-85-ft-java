package com.marketplace.models.valueobjets.profession;

import com.marketplace.exceptions.profession.ProfessionTitleEx;
import jakarta.persistence.Embeddable;

@Embeddable
public record ProfessionTitle(String title) {

    private static final String INVALID_NAME = "Invalid title";
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 30;

    public ProfessionTitle {
        validateName(title);
    }

    public static void validateName(String title){
        if (title == null || title.length() < MIN_LENGTH || title.length() > MAX_LENGTH){
            throw new ProfessionTitleEx(INVALID_NAME);
        }
    }


}
