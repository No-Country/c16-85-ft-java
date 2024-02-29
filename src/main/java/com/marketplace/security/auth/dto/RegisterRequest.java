package com.marketplace.security.auth.dto;

import lombok.Builder;

@Builder
public record RegisterRequest (String username,
                                String password,
                                String firstname,
                                String lastname,
                                String birthday,
                                String mobile,
                                String address){}
