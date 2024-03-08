package com.marketplace.exceptions.user.persistenceexceptions;

import lombok.RequiredArgsConstructor;
import lombok.experimental.StandardException;
import org.springframework.dao.DataAccessException;

@StandardException
public class UserAccountPersistenceException extends DataAccessException {
    private String message;
}
