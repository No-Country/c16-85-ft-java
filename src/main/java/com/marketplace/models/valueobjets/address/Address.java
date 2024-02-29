package com.marketplace.models.valueobjets.address;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import jakarta.persistence.Embeddable;

@Embeddable
public  record Address(String address){

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 25;

    public Address{
        validateAddress(address);
    }

    private static void validateAddress(String address){
        if (address== null || address.length() < MIN_LENGTH || address.length() > MAX_LENGTH){
            throw new InvalidBusinessNameException(
                    "The Address name must contain between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.");
        }
    }
}
