package com.marketplace.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorResponse(int statusCode,
                            String message){

    public static ErrorResponse of(HttpStatus status, String message){
        return new ErrorResponse(status.value(), message);
    }

}
