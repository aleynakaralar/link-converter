package com.link.linkconverter;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface LinkConverterRepository extends MongoRepository<Link,String> {
    Link findByWebUrl(String webUrl);
}