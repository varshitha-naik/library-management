package com.example.library.controller;

import com.example.library.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // GET ALL BOOKS (HARDCODED)
    @GetMapping
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        books.add(new Book(
                "Clean Code",
                "Robert C. Martin",
                "978-0132350884",
                2008
        ));

        books.add(new Book(
                "Effective Java",
                "Joshua Bloch",
                "978-0134685991",
                2018
        ));

        books.add(new Book(
                "Spring in Action",
                "Craig Walls",
                "978-1617294945",
                2021
        ));

        return books;
    }

    // GET BOOK BY ID (HARDCODED)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Book book = new Book(
                "Clean Code",
                "Robert C. Martin",
                "978-0132350884",
                2008
        );

        return ResponseEntity.ok(book);
    }

    // CREATE BOOK (JUST ECHO BACK)
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return book;
    }

    // UPDATE BOOK (JUST ECHO BACK)
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long id,
            @RequestBody Book bookDetails) {

        return ResponseEntity.ok(bookDetails);
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok("Book deleted successfully");
    }
}
