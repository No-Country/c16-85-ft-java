package com.marketplace.exceptions.user.persistenceexceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "User Email already exists")
public class DuplicatedUserException extends UserAccountPersistenceException {
}