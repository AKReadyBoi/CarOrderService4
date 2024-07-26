package com.innowise.ryabov.cos4.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotUniqueValueExceptionHandler {
    @ExceptionHandler(NotUniqueValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleUserNotFound(NotUniqueValueException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
