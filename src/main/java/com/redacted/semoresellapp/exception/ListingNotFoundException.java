package com.redacted.semoresellapp.exception;

public class ListingNotFoundException extends RuntimeException{
    public ListingNotFoundException(String message) {
        super(message);
    }
}
