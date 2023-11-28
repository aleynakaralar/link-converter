package com.example.ReadingIsGood.customer;

import com.fasterxml.jackson.annotation.JsonTypeId;
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
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private int customerOrderCount = 0;
    private boolean isBlackListed;
}
