package com.example.ReadingIsGood.analytics;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
public class BookAnalyticsController {
    private final BookAnalyticsService bookAnalyticsService;
    @GetMapping("/book/get-top-three-books")
    public String getTopThreeBooks() {
        return bookAnalyticsService.getTopThreeBooks();
    }
}
