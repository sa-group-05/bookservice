package com.iuh.nhom05.BookService.controller;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.service.BookService;
import com.iuh.nhom05.BookService.vo.Book_Athour_VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping("/findDetail/{id}")
    public Book_Athour_VO findByVo(@PathVariable int id){
        return bookService.findById_vo(id);
    }

    @GetMapping("")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id){
        return bookService.findById(id);
    }

    @PostMapping("")
    public void save(@RequestBody Book book) {
        bookService.save(book);
    }

    @PutMapping("")
    public void update(@RequestBody Book book) {
        bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        bookService.deleteById(id);
    }

}
