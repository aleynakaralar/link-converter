package com.example.ReadingIsGood.customer;


import com.example.ReadingIsGood.order.Order;
import com.example.ReadingIsGood.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private OrderService orderService;

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        repository.insert(customer);
    }

    public void updateExistingCustomer(UpdateCustomerRequest request, String id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("USER NOT FOUND");
        }
        Customer customer = optionalCustomer.get();
        customer.setAddress(request.getAddress());
        customer.setName(request.getName());
        customer.setPhoneNumber(request.getPhone());
        customer.setBlackListed(request.isBlackListed());
        repository.save(customer);
    }

    public void deleteExistingCustomer(String id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("USER NOT FOUND");
        }
        repository.delete(optionalCustomer.get());
    }

    public void incrementCustomerOrderCount(String customerId) {
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("USER NOT FOUND");
        }
        Customer customer = optionalCustomer.get();
        double orderCount = customer.getOrderCount();
        double incrementedCount = orderCount + 1;
        customer.setOrderCount(incrementedCount);
        repository.save(customer);
    }

    public void checkIsBlackListedValue(String customerId) {
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("USER NOT FOUND");
        }
        Customer customer = optionalCustomer.get();
        if (customer.isBlackListed()) {
            throw new CustomerNotOrderedException();
        }
    }

    public Customer getCustomerById(String customerId) {
        Optional<Customer> optionalCustomer = repository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new RuntimeException("CUSTOMER NOT FOUND");
        }
        return optionalCustomer.get();
    }




}




