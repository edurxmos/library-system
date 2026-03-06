package com.eduardo.library_system.library.student.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @NotBlank
        @Size(min = 3, max = 80)
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 1, max = 1)
        String grade,

        @NotBlank
        @Size(min = 1, max = 1)
        String classroom
) {}
