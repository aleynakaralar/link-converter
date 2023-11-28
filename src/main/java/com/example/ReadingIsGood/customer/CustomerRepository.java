package com.example.ReadingIsGood.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Page<Customer> findTop3ByOrderByCustomerOrderCountDesc(PageRequest pageRequest);
}
