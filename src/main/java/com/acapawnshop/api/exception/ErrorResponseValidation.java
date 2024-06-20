package com.acapawnshop.api.exception;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public record ErrorResponseValidation(String field, String error) {

    public ErrorResponseValidation(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

}
