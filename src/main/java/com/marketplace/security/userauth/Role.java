package com.marketplace.security.userauth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.marketplace.security.userauth.Permission.*;

@RequiredArgsConstructor
public enum Role {
    //USER(Collections.emptySet()), //CUSTOMER_READ
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE,

                    USER_READ,
                    USER_UPDATE,
                    USER_CREATE,
                    USER_DELETE,

                    CONTRACTOR_READ,
                    CONTRACTOR_UPDATE,
                    CONTRACTOR_CREATE,
                    CONTRACTOR_DELETE
            )
    ),
    USER(
            Set.of(
                    USER_READ,
                    USER_UPDATE,
                    USER_CREATE,
                    USER_DELETE
            )
    ),

    CONTRACTOR(
            Set.of(
                    CONTRACTOR_READ,
                    CONTRACTOR_UPDATE,
                    CONTRACTOR_CREATE,
                    CONTRACTOR_DELETE
            )
    )

    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){

        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;

    }
}
