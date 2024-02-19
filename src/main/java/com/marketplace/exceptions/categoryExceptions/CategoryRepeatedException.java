package com.marketplace.exceptions.categoryExceptions;

public class CategoryRepeatedException extends RuntimeException{

    public CategoryRepeatedException(String message) {
        super(message);
    }
}
