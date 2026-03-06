package com.eduardo.library_system.library.book.exceptions;

public class BookUnavailableException extends RuntimeException {
    public BookUnavailableException(String msg) {
        super(msg);
    }
}
