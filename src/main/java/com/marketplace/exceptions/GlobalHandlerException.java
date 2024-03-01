package com.marketplace.exceptions;


import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.user.InvalidEmailException;
import com.marketplace.exceptions.user.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler(InvalidEmailException.class)
    public UserErrorResponse invalidEmailExceptionHandler(InvalidEmailException ex){
        return new UserErrorResponse(ex.getMessage());
    }
}
