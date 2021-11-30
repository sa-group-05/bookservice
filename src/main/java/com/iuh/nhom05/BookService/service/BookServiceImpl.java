package com.iuh.nhom05.BookService.service;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.repository.BookRepository;
import com.iuh.nhom05.BookService.vo.Author;
import com.iuh.nhom05.BookService.vo.Book_Athour_VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    private String httpAuthor = "http://localhost:8082";
    private String httpBook = "http://localhost:8081";

    @Override
    public Book_Athour_VO findById_vo(int id) {
        Book_Athour_VO vo = new Book_Athour_VO();
        Book book = restTemplate.getForObject(httpBook + "/books/" + id, Book.class);
        vo.setBook(book);
        Author author = restTemplate.getForObject(httpAuthor + "/authors/" + book.getAuthorId(), Author.class);
        vo.setAuthor(author);
        return vo;
    }

}
