package com.example.ReadingIsGood.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {
    private List<String> books;
    private String customerId;

}
