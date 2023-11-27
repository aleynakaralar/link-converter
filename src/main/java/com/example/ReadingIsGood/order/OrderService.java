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

    /* public List<String> getOrdersByCustomerId(String id) {
        List<Order> order = repository.findAll();
        List<String> orderList = new ArrayList<>();
        for (Order o : order){
            String customerId = o.getCustomerId();
            if (Objects.equals(customerId, id)){
                orderList.add(o.getId());
            }
        }

        return orderList;
    }*/
    public List<String> getOrdersByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId).stream()
                .map(Order::getCustomerId)
                .collect(Collectors.toList());
    }


}
