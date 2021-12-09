package com.iuh.nhom05.BookService.service;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.vo.Book_Athour_VO;

import java.util.List;

public interface BookService {
    public Book_Athour_VO findById_vo(int id);
    public List<Book> findAll();
    public Book findById(int id);
    public void save(Book book);
    public void deleteById(int id);
}
