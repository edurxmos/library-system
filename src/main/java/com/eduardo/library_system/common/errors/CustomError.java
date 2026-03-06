package com.eduardo.library_system.common.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

}
