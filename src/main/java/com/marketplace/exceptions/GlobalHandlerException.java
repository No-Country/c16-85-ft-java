package com.marketplace.exceptions;


import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(InvalidBusinessNameException.class)
    public ResponseEntity<Map<String,String>> invalidBusinessNameExceptionHandler(InvalidBusinessNameException ex){
        Map<String,String> resp = new HashMap<>();
        resp.put("BUSINESS_NAME_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCeoNameException.class)
    public ResponseEntity<Map<String,String>> invalidCeoNameExceptionHandler(InvalidCeoNameException ex){
        Map<String,String> resp = new HashMap<>();
        resp.put("CEO_NAME_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAccountPersistenceException.class)
    public ResponseEntity<ErrorResponse> userAccountPersistenceException(UserAccountPersistenceException ex){
        ErrorResponse errorResponse;

        if(ex instanceof InvalidEmailException){
            errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        else if(ex instanceof DuplicatedUserException){
            errorResponse = ErrorResponse.of(HttpStatus.CONFLICT, ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
        }
        else {
            errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @ResponseBody
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> emailNotFoundExceptionHandler(EmailNotFoundException ex){

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    //UserWrongEmailOrPasswordException
    @ResponseBody
    @ExceptionHandler(IncorrectEmailOrPasswordException.class)
    public ResponseEntity<ErrorResponse> incorrectEmailOrPasswordException(IncorrectEmailOrPasswordException ex){

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.FORBIDDEN, ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, "JSON parse error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
