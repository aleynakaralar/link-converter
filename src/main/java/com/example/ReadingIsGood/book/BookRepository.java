package com.example.ReadingIsGood.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, String>{
    Page<Book> findTop3ByOrderByBookOrderCountDesc(PageRequest pageRequest);
}


