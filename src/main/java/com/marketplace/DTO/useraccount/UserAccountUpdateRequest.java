package com.marketplace.DTO.useraccount;

public record UserAccountUpdateRequest(String firstname,
                                       String lastname,
                                       String birthday,
                                       String mobile,
                                       String address
                                       ) {
}
