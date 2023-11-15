package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.book.BookService;
import com.example.ReadingIsGood.customer.Customer;
import com.example.ReadingIsGood.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final BookService bookService;
    private final CustomerService customerService;
    public List<Order> getOrders() {
        return repository.findAll();
    }
    public void addOrder(CreateOrderRequest request) {
        customerService.checkIsBlackListedValue(request.getCustomerId());
        bookService.checkStockCount(request.getBooks());
        double totalPrice = bookService.getTotalPriceForBooks(request.getBooks());
        Order order = Order.builder()
               .books(request.getBooks())
               .totalPrice(totalPrice)
               .customerId(request.getCustomerId())
               .build();
        customerService.incrementCustomerOrderCount(request.getCustomerId());
        bookService.decrementStockCount(request.getBooks());
        repository.insert(order);
    }
    public void deleteOrder(String id) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RuntimeException("BOOK NOT FOUND");
        }
        repository.delete(optionalOrder.get());
    }
    public Order getOrderDetails(String id) {
        Optional<Order> optionalOrder = repository.findById(id);
        return optionalOrder.orElse(null);
    }

}
