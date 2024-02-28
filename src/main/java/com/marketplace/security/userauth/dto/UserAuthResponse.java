package com.marketplace.security.userauth.dto;

import com.marketplace.models.valueobjets.useraccount.Role;

public record UserAuthResponse(Long id,
                               String username,
                               Role role,
                               Long userAccountId
                               ) {
}
