package com.iuh.nhom05.BookService.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Details about the book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the author")
    private int id;
    @ApiModelProperty(notes = "The book's imageUrl")
    private String imageUrl;
    @ApiModelProperty(notes = "The book's title")
    private String title;
    @ApiModelProperty(notes = "The book's authorId")
    private int authorId;
    @ApiModelProperty(notes = "The book's price")
    private double price;
    @ApiModelProperty(notes = "The book's publishedYear")
    private int publishedYear;
}
