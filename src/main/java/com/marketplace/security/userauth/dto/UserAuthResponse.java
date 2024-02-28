package com.marketplace.security.userauth.dto;

public record UserAuthResponse(Long id,
                               String username,
                               String role,
                               Long userAccountId
                               ) {
}
