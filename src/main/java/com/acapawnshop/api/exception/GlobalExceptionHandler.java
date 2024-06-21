package com.acapawnshop.api.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity treatError400(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ErrorResponseValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleConstrainViolation(DataIntegrityViolationException e) {
        String errorMessage = e.getMessage();

        if (errorMessage.contains("constraint [users.email]")) {
            String response = "Unable to register: email is already in use";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else if (errorMessage.contains("constraint [user_credentials.user_name]")) {
            String response = "Cannot register: username already exists";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } else {
            String response = "Integrity violation error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
