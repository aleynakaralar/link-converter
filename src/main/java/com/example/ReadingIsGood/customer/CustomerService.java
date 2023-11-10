package com.example.ReadingIsGood.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;


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

        repository.save(customer);
    }

    public void deleteExistingCustomer(String id) {
       Optional<Customer> optionalCustomer = repository.findById(id);
       if (optionalCustomer.isEmpty()) {
           throw new RuntimeException("USER NOT FOUND");
       }
       repository.delete(optionalCustomer.get());
    }
}









