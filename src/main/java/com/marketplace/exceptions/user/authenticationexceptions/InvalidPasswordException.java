package com.marketplace.exceptions.user.authenticationexceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Password is incorrect")
public class InvalidPasswordException extends UserAuthenticationException {
}
