package com.example.ReadingIsGood.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private List<String> books;
    private double totalPrice;
    private String customerId;
}
