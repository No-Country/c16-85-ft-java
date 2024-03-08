package com.marketplace.models.valueobjets.address;

import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import jakarta.persistence.Embeddable;

@Embeddable
public  record Address(String address) {
}