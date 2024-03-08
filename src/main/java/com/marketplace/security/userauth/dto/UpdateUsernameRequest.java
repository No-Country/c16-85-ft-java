package com.marketplace.security.userauth.dto;

import lombok.Builder;

@Builder
public record UpdateUsernameRequest(String currentUsername,
                                    String newUsername,
                                    String confirmUsername,
                                    String password) {

}
