package com.eduardo.library_system.dtos.book;

public record BookResponse(Long id, String title, String author, boolean available) {
}
