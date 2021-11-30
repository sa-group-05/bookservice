package com.iuh.nhom05.BookService.controller;

import com.iuh.nhom05.BookService.service.BookService;
import com.iuh.nhom05.BookService.vo.Book_Athour_VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookRestApi {
    @Autowired
    private BookService bookService;

    @GetMapping("/findDetail/{id}")
    public Book_Athour_VO findByVo(@PathVariable int id){
        return bookService.findById_vo(id);
    }

}
