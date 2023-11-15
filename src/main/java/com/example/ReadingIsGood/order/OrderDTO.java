package com.example.ReadingIsGood.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderDTO {
    private double totalPrice;
    private String customerId;
}
