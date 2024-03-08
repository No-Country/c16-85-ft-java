package com.marketplace.exceptions.user.authenticationexceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends UserAuthenticationException {
}
