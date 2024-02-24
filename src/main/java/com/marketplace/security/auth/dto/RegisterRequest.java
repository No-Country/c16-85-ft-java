package com.marketplace.security.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthday;
    private String mobile;
    //private String address;
    //private String city;
//    private String province;
//    private String country;
//    private String coordinates;

    //private Role role;
}
