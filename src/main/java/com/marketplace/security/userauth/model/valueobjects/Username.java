package com.marketplace.security.userauth.model.valueobjects;

import com.marketplace.exceptions.user.InvalidEmailException;
import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public record Username(String username) {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.com$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Username{
        validateEmail(username);
    }

    public void validateEmail(String username){

        if (username == null || !EMAIL_PATTERN.matcher(username).matches()) {
            throw new InvalidEmailException("Invalid email format: " + username);
        }
    }
}
