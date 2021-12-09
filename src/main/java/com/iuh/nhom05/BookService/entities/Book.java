package com.iuh.nhom05.BookService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String imageUrl;
    private String title;
    private int authorId;
    private double price;
    private int publishedYear;
}
