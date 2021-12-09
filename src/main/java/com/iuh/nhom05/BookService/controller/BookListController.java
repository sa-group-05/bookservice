package com.iuh.nhom05.BookService.controller;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.repository.BookListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis/list/books")
public class BookListController {
    @Autowired
    private BookListRepository bookListRepository;

    @PostMapping
    public Book saveAuthor(@RequestBody Book book) {
        bookListRepository.saveBook(book);
        return book;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookListRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getAuthorById(@PathVariable("id") Integer id) {
        return bookListRepository.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        bookListRepository.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookListRepository.deleteById(id);
    }
}
