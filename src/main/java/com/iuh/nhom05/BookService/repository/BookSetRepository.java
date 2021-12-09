package com.iuh.nhom05.BookService.repository;

import com.iuh.nhom05.BookService.entities.Book;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class BookSetRepository {
    private static final String KEY = "BOOK_SET";

    private SetOperations setOperations;
    private RedisTemplate redisTemplate;

    public BookSetRepository(RedisTemplate redisTemplate) {
        this.setOperations = redisTemplate.opsForSet();
        this.redisTemplate = redisTemplate;
    }

    public void saveBook(Book book) {
        setOperations.add(KEY, book);
    }

    public Set<Book> findAll() {
        return setOperations.members(KEY);
    }

    public void update(Book book) {
        saveBook(book);
    }
}
