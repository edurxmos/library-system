package com.eduardo.library_system.library.services.exceptions;

public class BookUnavailableException extends RuntimeException {
    public BookUnavailableException(String msg) {
        super(msg);
    }
}
