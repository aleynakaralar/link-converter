package com.example.ReadingIsGood.analytics;
import com.example.ReadingIsGood.order.Order;
import com.example.ReadingIsGood.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderAnalyticsService {
    private final OrderRepository repository;
    public double getAverageOrderPrice() {
        List<Order> orders = repository.findAll();
        double average = 0;
        for(Order o : orders ){
            average +=(o.getTotalPrice())/(orders.size());
        }
        return average;
    }
}
