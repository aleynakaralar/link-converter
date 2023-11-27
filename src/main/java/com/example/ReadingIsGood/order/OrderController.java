package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.analytics.OrderAnalyticsService;
import com.example.ReadingIsGood.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/order-list")
    public List<Order> allOrders() {
        return orderService.getOrders();
    }
    @PostMapping("/add-order")
    public void addOrder(@RequestBody CreateOrderRequest request) {
        orderService.addOrder(request);
    }
    @DeleteMapping("/delete-order/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
    @GetMapping("/order-details/{id}")
    public ResponseEntity<Order> getDetails(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderDetails(id));
    }
    @GetMapping("/order/by-id/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable String id) {
        Order order = orderService.getOrderDetails(id);
        OrderDTO dto = OrderDTO.builder()
                .totalPrice(order.getTotalPrice())
                .customerId(order.getCustomerId())
                .build();
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/order/by-customer-id/{customerId}")
    public List<String> getOrderByCustomerId(@PathVariable String customerId) {
       return orderService.getOrdersByCustomerId(customerId);

    }
}
