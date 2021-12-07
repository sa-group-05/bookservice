package com.iuh.nhom05.BookService.controller;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.repository.BookHashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/redis/hash/books")
public class BookHashController {
    @Autowired
    private BookHashRepository bookHashRepository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        bookHashRepository.saveBook(book);
        return book;
    }

    @GetMapping
    public Map<Integer, Book> findAll() {
        return bookHashRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getAuthorById(@PathVariable("id") Integer id) {
        return bookHashRepository.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookHashRepository.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookHashRepository.deleteById(id);
    }
}
