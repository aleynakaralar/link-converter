package com.example.ReadingIsGood.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    public List<Book> getBooks() {
       return  repository.findAll();
    }
    public void addBook(Book book) {
        repository.insert(book);
    }
   public void updateExistingBook(UpdateBookRequest request, String id) {
       Book book = repository.findById(id).orElseThrow(RuntimeException::new);
       book.updatedBook(request.getPrice(), request.getStock());
       repository.save(book);
   }
    public void deleteBook(String id) {
        repository.delete(repository.findById(id).orElseThrow(RuntimeException::new));
    }
    public double getTotalPriceForBooks(List<String> bookIds) {
        List<Book> books = repository.findAllById(bookIds);
        return books.stream()
                .mapToDouble(Book :: getTotalPriceForBooks)
                .sum();
    }
    public void decrementStockCount(List<String> bookIds) {
        List<Book> books = repository.findAllById(bookIds);
        List<Book> updatedBooks = books.stream()
                .map(Book :: decrementStockCount)
                .collect(Collectors.toList());
        repository.saveAll(updatedBooks);
    }

    public void incrementOrderCount(List<String> bookIds) {
        List<Book> books = repository.findAllById(bookIds);
        List<Book> updateBooks = books.stream()
                .map(Book::incrementOrderCount)
                .collect(Collectors.toList());
        repository.saveAll(updateBooks);
    }
    public void checkStockCount(List<String> bookIds) {
        List<Book> books = repository.findAllById(bookIds);
        boolean outOfStockBooksExist = books.stream()
                .allMatch(Book::outOfStock);
        if (outOfStockBooksExist) {
            throw new RuntimeException("BOOK OUT OF STOCK");
        }
    }
    public Book getBookById(String id) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("BOOK NOT FOUND");
        }
        return optionalBook.get();
    }

}
