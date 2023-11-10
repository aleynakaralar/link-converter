package com.example.ReadingIsGood.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String bookName;
    private String author;
    private double price;
    private int stock;
}
