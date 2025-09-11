package com.eduardo.library_system.dtos.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookRequest(
        @NotBlank
        @Size(min = 3, max = 120)
        String title,

        @NotBlank
        @Size(min = 3, max = 80)
        String author
) {}
