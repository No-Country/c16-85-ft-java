package com.marketplace.exceptions.user;

import lombok.experimental.StandardException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserAccountNotFound extends DataAccessException {
}
