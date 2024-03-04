package com.marketplace.DTO.useraccount;

import lombok.Builder;

@Builder
public record UserAccountResponse (String username,
                                    String firstname,
                                    String lastname,
                                    String role){

}
