package com.example.ReadingIsGood.customer;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class DB {

    List<Customer> customerList = new ArrayList<>();

    public void add(Customer customer) {
        customerList.add(customer);
    }

    public void delete(Customer customer){
        customerList.remove(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerList;
    }

}
