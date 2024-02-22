package com.marketplace.models.valueobjets.contractor;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;

public record BusinessName(String businessName) {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 18;

    public BusinessName{
        validateName(businessName);
    }

    private static void validateName(String businessName){
        if (businessName == null || businessName.length() < MIN_LENGTH || businessName.length() > MAX_LENGTH){
            throw new InvalidBusinessNameException(
                    "The business name must contain between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }
    }
}
