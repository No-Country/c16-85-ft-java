package com.marketplace.models.valueobjets.contractor;

import com.marketplace.exceptions.contractor.InvalidCeoNameException;

public record CeoLastName(String lastName) {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 15;

    public CeoLastName{
        validateLastName(lastName);
    }

    private static void validateLastName(String name){
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH){
            throw new InvalidCeoNameException(
                    "The ceo lastname must contain between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }
    }
}
