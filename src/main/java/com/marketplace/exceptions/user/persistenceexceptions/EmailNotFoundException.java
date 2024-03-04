package com.marketplace.exceptions.user.persistenceexceptions;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

@StandardException
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Email not found")
public class EmailNotFoundException extends UserAccountPersistenceException {
}
