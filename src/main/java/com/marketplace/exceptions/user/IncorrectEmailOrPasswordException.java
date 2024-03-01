package com.marketplace.exceptions.user;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason="Email or password are incorrect")
public class IncorrectEmailOrPasswordException extends BadCredentialsException {}