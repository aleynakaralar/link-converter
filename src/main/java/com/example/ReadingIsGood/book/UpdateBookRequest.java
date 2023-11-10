package com.example.ReadingIsGood.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateBookRequest {

    private double price;
    private int stock;
}