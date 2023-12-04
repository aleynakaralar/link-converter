package com.example.ReadingIsGood.order;

import com.example.ReadingIsGood.book.BookService;
import com.example.ReadingIsGood.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        bookService.incrementOrderCount(request.getBooks());
        repository.insert(order);
    }

    public void deleteOrder(String id) {
        repository.delete(repository.findById(id).orElseThrow(RuntimeException::new));
    }
    public Order getOrderDetails(String id) {
        Optional<Order> optionalOrder = repository.findById(id);
        return optionalOrder.orElse(null);

    }
    public List<String> getOrdersByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(Order::getCustomerId)
                .collect(Collectors.toList());
    }


}
