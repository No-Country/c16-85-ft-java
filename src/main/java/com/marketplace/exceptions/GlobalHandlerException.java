package com.marketplace.exceptions;


import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.user.*;
import com.marketplace.exceptions.user.authenticationexceptions.*;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.ConnectException;
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
    //
    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleUserAuthenticationException(UserAuthenticationException ex){
        ErrorResponse errorResponse= errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

        if(ex instanceof InvalidEmailException ||
            ex instanceof MismatchedEmailException ||
            ex instanceof DuplicatedEmailException){

            errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        } else if(ex instanceof InvalidPasswordException) {
            errorResponse = ErrorResponse.of(HttpStatus.FORBIDDEN, ex.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler(UserAccountPersistenceException.class)
    public ResponseEntity<ErrorResponse> handleUserAccountPersistenceException(UserAccountPersistenceException ex){
        ErrorResponse errorResponse;

        if(ex instanceof DuplicatedUserException){
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
    public ResponseEntity<ErrorResponse> handleEmailNotFoundException(EmailNotFoundException ex){

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

    }

    //UserWrongEmailOrPasswordException
    @ResponseBody
    @ExceptionHandler(IncorrectEmailOrPasswordException.class)
    public ResponseEntity<ErrorResponse> handleIncorrectEmailOrPasswordException(IncorrectEmailOrPasswordException ex){

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.FORBIDDEN, ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, "Request parse error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<ErrorResponse> handleConnectException(ConnectException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "Connection Refused");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, "Wrong Input");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> handleExpiredJwtException(ExpiredJwtException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, "Session has expired");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
