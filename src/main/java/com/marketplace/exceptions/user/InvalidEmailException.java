package com.marketplace.exceptions.user;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid email format")
public class InvalidEmailException extends IllegalArgumentException{
}
