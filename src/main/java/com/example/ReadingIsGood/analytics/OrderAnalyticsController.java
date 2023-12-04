package com.example.ReadingIsGood.analytics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
public class OrderAnalyticsController {
    private final OrderAnalyticsService orderAnalyticsService;
    @GetMapping("/order/average-order-price")
    public double getAverageOrderPrice() {
        return orderAnalyticsService.getAverageOrderPrice();
    }
}
