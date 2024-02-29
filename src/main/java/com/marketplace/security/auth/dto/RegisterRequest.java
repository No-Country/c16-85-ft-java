package com.marketplace.security.auth.dto;

import com.marketplace.DTO.useraccount.UserAccountRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record RegisterRequest (String username,
                                String password,
                                String firstname,
                                String lastname,
                                String birthday,
                                String mobile,
                                String address){}
