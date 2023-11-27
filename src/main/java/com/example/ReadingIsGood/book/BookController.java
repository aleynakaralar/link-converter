package com.example.ReadingIsGood.book;

import com.example.ReadingIsGood.analytics.BookAnalyticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping("/book-list")
    public List<Book> allBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/add-book")
    public void addBook(@RequestBody CreateBookRequest request) {
        Book book = Book.builder()
                .bookName(request.getBookName())
                .author(request.getAuthor())
                .price(request.getPrice())
                .stock(request.getStock())
                .bookOrderCount(request.getBookOrderCount())
                .build();
        bookService.addBook(book);
    }

    @PutMapping("/update-book{id}")
    public void updateBook(@RequestBody UpdateBookRequest request, @PathVariable String id) {
        bookService.updateExistingBook(request, id);
    }

    @DeleteMapping("/delete-book{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/book/by-id/{id}")
    public ResponseEntity<BookDTO> getBookDetail(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        BookDTO dto = BookDTO.builder()
                .price(book.getPrice())
                .stock(book.getStock())
                .build();
        return ResponseEntity.ok(dto);
    }

}
