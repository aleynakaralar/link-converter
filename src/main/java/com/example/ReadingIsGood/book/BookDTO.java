package com.example.ReadingIsGood.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BookDTO {
    private double price;
    private int stock;
}
