package com.iuh.nhom05.BookService.service;

import com.iuh.nhom05.BookService.entities.Book;
import com.iuh.nhom05.BookService.repository.BookRepository;
import com.iuh.nhom05.BookService.vo.Author;
import com.iuh.nhom05.BookService.vo.Book_Athour_VO;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    private String httpAuthor = "http://localhost:8082";

    @Retry(name = "basic")
    @Override
    public Book_Athour_VO findById_vo(int id) {
        Book_Athour_VO vo = new Book_Athour_VO();
        Book book = findById(id);
        vo.setBook(book);
        Author author = restTemplate.getForObject(httpAuthor + "/authors/" + book.getAuthorId(), Author.class);
        vo.setAuthor(author);
        return vo;
    }

    @RateLimiter(name = "basic")
    @Override
    public List<Book> findAll() {
        List<Book> listBook = bookRepository.findAll();
        return listBook;
    }

    @RateLimiter(name = "timeout")
    @Override
    public Book findById(int id) {
        Optional<Book> rs = bookRepository.findById(id);
        Book book = null;
        if (rs.isPresent()) {
            book = rs.get();
        }
        return book;
    }

    @Retry(name = "throwingException")
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Retry(name = "ignoreException")
    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

}
