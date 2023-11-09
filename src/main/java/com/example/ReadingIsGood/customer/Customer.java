package com.example.ReadingIsGood.customer;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Customer {

    String id;
    String name;
    String phoneNumber;
}
