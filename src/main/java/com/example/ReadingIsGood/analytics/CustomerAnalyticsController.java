package com.example.ReadingIsGood.analytics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerAnalyticsController {
    private final CustomerAnalyticsService customerAnalyticsService;
    @GetMapping("/customer/get-top-three-customers")
    public String getTopThreeCustomerByOrderCount() {
        return customerAnalyticsService.getTopThreeCustomers();
    }
}
