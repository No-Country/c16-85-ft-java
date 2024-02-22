package com.marketplace.models.valueobjets.contractor;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import jakarta.persistence.Embeddable;

@Embeddable
public record CeoName(String name) {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 15;

    public CeoName{
        validateName(name);
    }

    private static void validateName(String name){
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH){
            throw new InvalidCeoNameException(
                    "The ceo name must contain between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }
    }
}
