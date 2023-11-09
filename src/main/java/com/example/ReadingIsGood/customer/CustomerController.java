package com.example.ReadingIsGood.customer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customer-list")
    public List allCustomers() {

        return customerService.getCustomers();
    }

    @PostMapping("/add-customers")
    public void addStudents(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }


    @PutMapping("/update-customer/{name}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable String name) {
        customerService.updateExistingCustomer(name, customer);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteExistingCustomer(id);
    }



}
