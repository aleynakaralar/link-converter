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
        Customer customer = repository.findById(id).orElseThrow(RuntimeException::new);
        customer.updatedCustomer(request.getAddress(), request.getName(), request.getPhone(), request.isBlackListed());
        repository.save(customer);
    }

    public void deleteExistingCustomer(String id) {
        repository.delete(repository.findById(id).orElseThrow(RuntimeException::new));
    }
    public void incrementCustomerOrderCount(String customerId) {
       Customer customer = repository.findById(customerId).orElseThrow(RuntimeException::new);
       customer.incrementCusOrderCount();
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
            throw new CustomerNotFoundException();
        }
        return optionalCustomer.get();
    }




}




