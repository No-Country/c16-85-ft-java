package com.marketplace.security.auth.dto;

import lombok.Builder;

@Builder
public record AuthenticationResponse (String username,
                                      String role,
                                      String token,
                                      String message){




}
