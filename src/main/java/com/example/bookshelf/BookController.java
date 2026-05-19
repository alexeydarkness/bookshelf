package com.example.bookshelf;

import com.example.bookshelf.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
}
        bookRepository.deleteById(id);
        return "Книга удалена";
                }

@PutMapping("/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
    Book updatedBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    updatedBook.setTitle(book.getTitle());
    updatedBook.setAuthor(book.getAuthor());
    return bookRepository.save(updatedBook);
}


@GetMapping("/{id}")
public Book getBookById(@PathVariable Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
}

@GetMapping("/search/author")
public List<Book> searchByAuthor(@RequestParam String name) {
    return bookRepository.findByAuthor(name);
}

@GetMapping("/search/title")
public List<Book> searchByTttle(@RequestParam String keyword) {
    return bookRepository.findByTitleContaining(keyword);
}

@GetMapping("search/")
public List<Book>search(@RequestParam(required = false) String author, @RequestParam(required = false) String title) {
    if (author != null && title != null) {
        return bookRepository.findByAuthorAndTitleContaining(author, title);
    } else if (author != null) {
        return bookRepository.findByAuthor(author);
    } else if (title != null) {
        return bookRepository.findByTitleContaining(title);
    } else {
        return bookRepository.findAll();
    }
}

}
