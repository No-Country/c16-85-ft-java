package com.marketplace.exceptions.contractor;

public class InvalidBusinessNameException extends RuntimeException{
    public InvalidBusinessNameException(String message){
        super(message);
    }
}
