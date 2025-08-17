package com.eduardo.library_system.dtos.student;

public record StudentResponse(Long id, String name, String email, char grade, char classroom) {
}
