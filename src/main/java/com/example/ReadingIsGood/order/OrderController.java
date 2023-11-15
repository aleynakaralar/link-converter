package com.example.ReadingIsGood.order;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/order-list")
    public List allOrders(){
        return orderService.getOrders();
    }
    @PostMapping("/add-order")
    public void addOrder(@RequestBody CreateOrderRequest request) {
        orderService.addOrder(request);
    }
    @DeleteMapping("/delete-order/{id}")
    public void deleteOrder(@PathVariable String id ){
        orderService.deleteOrder(id);
    }
    @GetMapping("/order-details/{id}")
    public ResponseEntity<Order> getDetails(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrderDetails(id));
    }
}
