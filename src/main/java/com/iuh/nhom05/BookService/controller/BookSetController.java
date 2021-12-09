package com.iuh.nhom05.BookService.controller;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.repository.BookSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/redis/set/books")
public class BookSetController {
    @Autowired
    private BookSetRepository bookSetRepository;

    @PostMapping
    public Book saveAuthor(@RequestBody Book book) {
        bookSetRepository.saveBook(book);
        return book;
    }

    @GetMapping
    public Set<Book> findAll() {
        return bookSetRepository.findAll();
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookSetRepository.update(book);
    }
}
