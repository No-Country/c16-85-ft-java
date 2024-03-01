package com.marketplace.exceptions.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public record UserErrorResponse (int statusCode,
                                 String message){

    public static UserErrorResponse of(HttpStatus status, String message){
        return new UserErrorResponse(status.value(), message);
    }

}
