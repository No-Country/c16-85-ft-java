package com.marketplace.security.userauth.dto;

import lombok.Builder;

@Builder
public record UpdatePasswordRequest(String currentPassword,
                                    String newPassword,
                                    String confirmationPassword){


}
