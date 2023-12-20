package com.link.linkconverter;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "links")
public class Link {
    @Id
    private String id;
    private String webUrl;
    private String deeplink;
}