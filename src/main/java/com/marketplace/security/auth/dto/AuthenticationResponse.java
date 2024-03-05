package com.marketplace.security.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record AuthenticationResponse (String username,
                                      String role,
                                      @JsonProperty("access_token")
                                      String accessToken,
                                      @JsonProperty("refresh_token")
                                      String refreshToken,
                                      String message){




}
