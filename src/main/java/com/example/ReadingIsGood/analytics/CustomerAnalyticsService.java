package com.example.ReadingIsGood.analytics;

import com.example.ReadingIsGood.customer.Customer;
import com.example.ReadingIsGood.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class CustomerAnalyticsService {
    private final CustomerRepository repository;
    public String getTopThreeCustomers() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Customer> topThreeCustomersPage = repository.findTop3ByOrderByCustomerOrderCountDesc(pageRequest);

        StringBuilder result = new StringBuilder("Top Three Customers:\n");

        for (Customer customer : topThreeCustomersPage.getContent()) {
            result.append("Customer Name: ").append(customer.getName())
                    .append("\n");
        }
        return result.toString();
    }
}
