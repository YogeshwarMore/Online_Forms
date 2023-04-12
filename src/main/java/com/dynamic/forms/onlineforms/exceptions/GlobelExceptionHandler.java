package com.dynamic.forms.onlineforms.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {
    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<String> handleMyCustomException(MyCustomException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}
