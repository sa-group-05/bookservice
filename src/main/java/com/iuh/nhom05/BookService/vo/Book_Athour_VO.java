package com.iuh.nhom05.BookService.vo;

import com.iuh.nhom05.BookService.entities.Book;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book_Athour_VO {
    private Book book;
    private Author author;
}
