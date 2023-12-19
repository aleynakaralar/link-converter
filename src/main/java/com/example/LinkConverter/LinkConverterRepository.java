package com.example.LinkConverter;

import com.example.LinkConverter.Link;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkConverterRepository extends MongoRepository<Link,String> {
}