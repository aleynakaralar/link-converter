package com.example.ReadingIsGood.customer;

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

    public Customer updatedCustomer(String address, String name, String phoneNumber, boolean isBlackListed) {
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isBlackListed = isBlackListed;
        return this;
    }

    public Customer incrementCusOrderCount() {
        this.customerOrderCount += 1;
        return this;
    }




}
