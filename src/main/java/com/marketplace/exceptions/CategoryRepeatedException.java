package com.marketplace.exceptions;

public class CategoryRepeatedException extends RuntimeException{

    public CategoryRepeatedException(String message) {
        super(message);
    }
}
