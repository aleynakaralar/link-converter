package com.example.LinkConverter.repository;

import com.example.LinkConverter.LinkConverter;
import com.example.LinkConverter.link.Link;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkConverterRepository extends MongoRepository<Link,String> {
}