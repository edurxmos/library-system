package com.eduardo.library_system.services.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
