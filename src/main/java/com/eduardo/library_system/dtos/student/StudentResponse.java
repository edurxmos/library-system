package com.eduardo.library_system.dtos.student;

public record StudentResponse(Long id, String name, String email, String grade, String classroom) {
}
