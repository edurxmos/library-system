package com.eduardo.library_system.library.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldMessage {

    private String fieldName;
    private String message;

}
