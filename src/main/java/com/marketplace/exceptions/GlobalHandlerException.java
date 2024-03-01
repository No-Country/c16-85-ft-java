package com.marketplace.exceptions;


import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.user.DuplicatedUserException;
import com.marketplace.exceptions.user.InvalidEmailException;
import com.marketplace.exceptions.user.dto.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ResponseBody
    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<UserErrorResponse> invalidEmailExceptionHandler(InvalidEmailException ex){
        UserErrorResponse errorResponse = UserErrorResponse.of(HttpStatus.BAD_REQUEST, ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ResponseBody
    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<UserErrorResponse> duplicatedUserExceptionHandler(DuplicatedUserException ex){
        UserErrorResponse errorResponse = UserErrorResponse.of(HttpStatus.CONFLICT, ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
