package com.example.ReadingIsGood.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody CreateCustomerRequest request) {
        Customer customer = Customer.builder()
                .address(request.getAddress())
                .phoneNumber(request.getPhone())
                .name(request.getName())
                .isBlackListed(request.isBlackListed())
                .build();
        customerService.addNewCustomer(customer);
    }
    @PutMapping("/update-customer/{id}")
    public void updateCustomer(@RequestBody UpdateCustomerRequest request, @PathVariable String id) {
        customerService.updateExistingCustomer(request, id);
    }

    @DeleteMapping("/delete-customer/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteExistingCustomer(id);
    }

    @GetMapping("/customer/by-id/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        CustomerDTO dto = CustomerDTO.builder()
                .id(customer.getId())
                .phoneNumber(customer.getPhoneNumber())
                .name(customer.getName())
                .build();
        return ResponseEntity.ok(dto);
    }
}
