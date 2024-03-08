package com.marketplace.exceptions.user.authenticationexceptions;

import lombok.experimental.StandardException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
public class UserAuthenticationException extends AuthenticationException {
}
