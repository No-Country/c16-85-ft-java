package com.marketplace.exceptions.user;

import lombok.experimental.StandardException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "User could not be persisted")
public class CannotPersistUserException extends DataAccessException {
}
