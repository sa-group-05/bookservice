package com.iuh.nhom05.BookService.repository;

import com.iuh.nhom05.BookService.entities.Book;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookListRepository {
    private static final String KEY = "BOOK_LIST";

    private ListOperations listOperations;
    private RedisTemplate redisTemplate;

    public BookListRepository(RedisTemplate redisTemplate) {
        this.listOperations = redisTemplate.opsForList();
        this.redisTemplate = redisTemplate;
    }

    public void saveBook(Book book) {
        listOperations.rightPush(KEY, book);
    }

    public List<Book> findAll() {
        return listOperations.range(KEY, 0, -1);
    }

    public Book findById(Integer id) {
        List<Book> books = findAll();
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void update(Book book) {
        saveBook(book);
    }

    public void deleteById(Integer id) {
        listOperations.remove(KEY, 1, findById(id));
    }
}
