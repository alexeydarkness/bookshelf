package com.example.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // Глобальный обработчик для всех контроллеров
public class GlobalExceptionHandler {

    // Обработка BookNotFoundException
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()  // 404
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Обработка всех остальных ошибок
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "Внутренняя ошибка сервера: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()  // 500
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}