package com.example.ReadingIsGood.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    private String bookName;
    private String author;
    private double price;
    private int stock;
    private int bookOrderCount = 0;
}
