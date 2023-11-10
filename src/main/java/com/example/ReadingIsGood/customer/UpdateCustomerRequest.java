package com.example.ReadingIsGood.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class UpdateCustomerRequest {
    private String name;
    private String phone;
    private String address;
}
