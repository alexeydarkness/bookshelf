package com.example.bookshelf.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Книга с ID " + id + " не найдена");
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}