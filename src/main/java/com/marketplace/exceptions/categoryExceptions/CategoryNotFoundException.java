package com.marketplace.exceptions.categoryExceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
