package com.example.ReadingIsGood.analytics;

import com.example.ReadingIsGood.book.Book;
import com.example.ReadingIsGood.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookAnalyticsService {

    private final BookRepository repository;
    public String getTopThreeBooks() {

        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Book> topThreeBooksPage = repository.findTop3ByOrderByBookOrderCountDesc(pageRequest);

        StringBuilder result = new StringBuilder("Top Three Books:\n");

        for (Book book : topThreeBooksPage.getContent()) {
            result.append("Id: ").append(book.getId())
                    .append("\n");
        }

        return result.toString();

    }



}
