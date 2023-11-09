package com.example.ReadingIsGood.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final DB db;


    public List<Customer> getCustomers() {

        return db.getAllCustomer();

    }


    public void addNewCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        db.add(customer);

    }


    public void updateExistingCustomer(String name, Customer customer) {
        List<Customer> allCustomers = db.getAllCustomer();
        for (Customer customerTemp : allCustomers) {
            if (customer.getName().equals(name)) {
                int i = allCustomers.indexOf(customerTemp);
                allCustomers.set(i, customer);
            }
        }
    }

    public void deleteExistingCustomer(String id) {
        List<Customer> allCustomers = db.getAllCustomer();
        for (Customer customerTemp : allCustomers) {
            if (customerTemp.getId().equals(id)) {
                allCustomers.remove(customerTemp);
            }

            }
        }
    }









