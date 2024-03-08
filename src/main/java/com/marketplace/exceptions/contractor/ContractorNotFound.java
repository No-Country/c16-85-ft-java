package com.marketplace.exceptions.contractor;

public class ContractorNotFound extends RuntimeException{

    public ContractorNotFound(String message) {
        super(message);
    }
}
