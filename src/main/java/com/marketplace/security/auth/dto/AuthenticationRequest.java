package com.marketplace.security.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record AuthenticationRequest(String username,
                                    String password) {}
