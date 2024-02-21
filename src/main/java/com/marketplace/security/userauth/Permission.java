package com.marketplace.security.userauth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),

    CUSTOMER_READ("customer:read"),
    CUSTOMER_UPDATE("customer:update"),
    CUSTOMER_CREATE("customer:create"),
    CUSTOMER_DELETE("customer:delete"),

    CONTRACTOR_READ("contractor:read"),
    CONTRACTOR_UPDATE("contractor:update"),
    CONTRACTOR_CREATE("contractor:create"),
    CONTRACTOR_DELETE("contractor:delete")

    ;

    @Getter
    private final String permission;

}

