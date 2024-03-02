package com.marketplace.exceptions;


import com.marketplace.exceptions.category.CategoryNotFoundException;
import com.marketplace.exceptions.category.CategoryRepeatedException;
import com.marketplace.exceptions.contractor.ContractorNotFound;
import com.marketplace.exceptions.contractor.InvalidBusinessNameException;
import com.marketplace.exceptions.contractor.InvalidCeoNameException;
import com.marketplace.exceptions.profession.ProfessionNotFoundEx;
import com.marketplace.exceptions.profession.ProfessionTitleEx;
import com.marketplace.exceptions.profession.ProfessionUpdateEx;
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

}
