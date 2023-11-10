package com.example.ReadingIsGood.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;


    public List<Book> getBooks() {

       return  repository.findAll();
    }


    public void addBook(Book book){

        repository.insert(book);
    }

    public void updateExistingBook(UpdateBookRequest request, String id){
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("BOOK NOT FOUND");
        }
        Book book = optionalBook.get();
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());

        repository.save(book);
    }

    public void deleteBook(String id){
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("BOOK NOT FOUND");
        }

        repository.delete(optionalBook.get());

    }

}
