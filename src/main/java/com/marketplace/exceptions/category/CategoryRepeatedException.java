package com.marketplace.exceptions.category;

public class CategoryRepeatedException extends RuntimeException{

    public CategoryRepeatedException(String message) {
        super(message);
    }
}
