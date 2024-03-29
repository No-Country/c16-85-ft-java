package com.marketplace.exceptions.user.persistenceexceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserAccountNotFound extends EmailNotFoundException {
}
