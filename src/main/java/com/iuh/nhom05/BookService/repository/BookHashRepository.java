package com.iuh.nhom05.BookService.repository;

import com.iuh.nhom05.BookService.entities.Book;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BookHashRepository {
    private static final String KEY = "books";

    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public BookHashRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void saveBook(Book book) {
        hashOperations.putIfAbsent(KEY, book.getId(), book);
    }

    public Map<Integer, Book> findAll() {
        return hashOperations.entries(KEY);
    }

    public Book findById(Integer id) {
        return (Book) hashOperations.get(KEY, id);
    }

    public void update(Book book) {
        hashOperations.put(KEY, book.getId(), book);
    }

    public void deleteById(Integer id) {
        hashOperations.delete(KEY, (Object) id);
    }
}
