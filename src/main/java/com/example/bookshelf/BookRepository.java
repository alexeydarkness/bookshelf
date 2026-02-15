package com.example.bookshelf;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Найти все книги автора
    List<Book> findByAuthor(String author);

    // Найти книги где title содержит keyword
    List<Book> findByTitleContaining(String keyword);

    // Найти книги автора где title содержит keyword
    List<Book> findByAuthorAndTitleContaining(String author, String keyword);

    // Найти книги автора (игнорируя регистр)
    List<Book> findByAuthorIgnoreCase(String author);
}