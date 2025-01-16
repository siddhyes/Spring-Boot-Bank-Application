package com.example.spring.demo.exceptionHandler;

import java.time.LocalDateTime;

public record ErrorClass(LocalDateTime localDateTime, String message, String details, String errorCode) {
}
