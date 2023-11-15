package com.example.ReadingIsGood;

import com.example.ReadingIsGood.book.BookNotOrderedException;
import com.example.ReadingIsGood.customer.CustomerNotOrderedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = CustomerNotOrderedException.class)

    public ResponseEntity<Object> exception(CustomerNotOrderedException exception) {
        return new ResponseEntity<>("Customer can not give an order", HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = BookNotOrderedException.class)

    public ResponseEntity<Object> exception(BookNotOrderedException exception) {
        return new ResponseEntity<>( "Book does not have enough stock", HttpStatus.BAD_REQUEST);

    }
}
