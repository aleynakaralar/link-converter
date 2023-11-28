package com.example.ReadingIsGood.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int bookOrderCount = 0;

    public Book incrementOrderCount() {
        this.bookOrderCount += 1;
        return this;
    }

    public Book decrementStockCount() {
        this.bookOrderCount -= 1;
        return this;
    }

    @JsonIgnore
    public double getTotalPriceForBooks() {
        double total = 0d;
        total += getPrice();
       return total;
    }

    public Book updatedBook(double price, int stock) {
        this.price = price;
        this.stock = stock;
        return this;
    }



    @JsonIgnore
    public boolean inStock() {
        return this.stock > 0;
    }

    @JsonIgnore
    public boolean outOfStock() {
        return this.stock < 1;
    }
}
