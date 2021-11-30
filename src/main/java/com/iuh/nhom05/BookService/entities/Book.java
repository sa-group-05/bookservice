package com.iuh.nhom05.BookService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String id;
    private String imageUrl;
    private String title;
    private String authorId;
    private double price;
    private int publishedYear;
}
