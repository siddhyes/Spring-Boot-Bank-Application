package com.example.spring.demo.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorClass> handelAccountException(AccountNotFoundException accountException, WebRequest webRequest) {
        ErrorClass errorClass = new ErrorClass(LocalDateTime.now(), accountException.getMessage(), webRequest.getDescription(false), "ACCOUNT_NOT_FOUND");
        return new ResponseEntity<>(errorClass, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorClass> handelInsufficientBalanceException(InsufficientBalanceException accountException, WebRequest webRequest) {
        ErrorClass errorClass = new ErrorClass(LocalDateTime.now(), accountException.getMessage(), webRequest.getDescription(false), "Insufficient balance exception");
        return new ResponseEntity<>(errorClass, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorClass> generic(Exception accountException, WebRequest webRequest) {
        ErrorClass errorClass = new ErrorClass(LocalDateTime.now(), accountException.getMessage(), webRequest.getDescription(false), "" + "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
