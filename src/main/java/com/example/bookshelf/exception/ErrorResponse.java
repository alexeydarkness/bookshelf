package com.example.bookshelf.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
  private String message;
  private int status;
  private LocalDateTime timestamp;

  // Конструктор
  public ErrorResponse(String message, int status) {
    this.message = message;
    this.status = status;
    this.timestamp = LocalDateTime.now();
  }

  // Геттеры (сеттеры не нужны)
  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}