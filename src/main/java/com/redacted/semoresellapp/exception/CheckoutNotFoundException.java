package com.redacted.semoresellapp.exception;

public class CheckoutNotFoundException extends RuntimeException{
    public CheckoutNotFoundException(String message) {
        super(message);
    }
}
