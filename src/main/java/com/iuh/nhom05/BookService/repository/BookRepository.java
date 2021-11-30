package com.iuh.nhom05.BookService.repository;

import com.iuh.nhom05.BookService.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
