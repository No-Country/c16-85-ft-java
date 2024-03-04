package com.marketplace.exceptions;


import com.marketplace.exceptions.category.CategoryNotFoundException;
import com.marketplace.exceptions.category.CategoryRepeatedException;
import com.marketplace.exceptions.contractor.ContractorNotFound;
import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.profession.ProfessionNotFoundEx;
import com.marketplace.exceptions.profession.ProfessionTitleEx;
import com.marketplace.exceptions.profession.ProfessionUpdateEx;
import com.marketplace.exceptions.user.authenticationexceptions.*;
import com.marketplace.exceptions.user.persistenceexceptions.DuplicatedUserException;
import com.marketplace.exceptions.user.persistenceexceptions.EmailNotFoundException;
import com.marketplace.exceptions.user.persistenceexceptions.InvalidEmailOrPasswordException;
import com.marketplace.exceptions.user.persistenceexceptions.UserAccountPersistenceException;
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

    // Contractor Exceptions
    @ExceptionHandler(ContractorNotFound.class)
    public ResponseEntity<Map<String,String>> contractorNotFound(ContractorNotFound ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("CONTRACTOR_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    // Category Exceptions
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String,String>> categoryNotFound(CategoryNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("CATEGORY_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryRepeatedException.class)
    public ResponseEntity<Map<String,String>> categoryRepeated(CategoryRepeatedException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("CATEGORY_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    // Profession Exceptions
    @ExceptionHandler(ProfessionNotFoundEx.class)
    public ResponseEntity<Map<String,String>> professionNotFound(ProfessionNotFoundEx ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("PROFESSION_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProfessionTitleEx.class)
    public ResponseEntity<Map<String,String>> professionTitle(ProfessionTitleEx ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("PROFESSION_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProfessionUpdateEx.class)
    public ResponseEntity<Map<String,String>> professionUpdate(ProfessionUpdateEx ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("PROFESSION_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<Map<String,String>> tokenNotFoundExceptionHandler(TokenNotFoundException ex){
        Map<String,String> resp = new HashMap<>();
        resp.put("TOKEN_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
    //
    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleUserAuthenticationException(UserAuthenticationException ex){
        ErrorResponse errorResponse= errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

        if(ex instanceof InvalidEmailException ||
            ex instanceof MismatchedEmailException ||
            ex instanceof DuplicatedEmailException ||
            ex instanceof DuplicatedPasswordException ||
            ex instanceof MismatchedPasswordException){

            errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        } else if(ex instanceof InvalidPasswordException ||
                    ex instanceof InvalidEmailOrPasswordException) {
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
        if(ex instanceof EmailNotFoundException){
            errorResponse = ErrorResponse.of(HttpStatus.NOT_FOUND, ex.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        else {
            errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

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
