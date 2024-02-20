package com.marketplace.models.valueobjets.contractor;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;

public record BusinessName(String name) {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 18;

    public BusinessName{
        validateName(name);
    }

    private static void validateName(String name){
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH){
            throw new InvalidBusinessNameException(
                    "The business name must contain between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }
    }
}
