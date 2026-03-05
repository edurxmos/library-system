package com.eduardo.library_system.library.services.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
