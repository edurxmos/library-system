package com.eduardo.library_system.services.exceptions;

public class BookUnavailableException extends RuntimeException {
    public BookUnavailableException(String msg) {
        super(msg);
    }
}
