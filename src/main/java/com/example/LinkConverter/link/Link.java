package com.example.LinkConverter.link;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "links")
public class Link {
    @Id
    private String id;
    private String webUrl;
    private String deeplink;

    public Link() {
    }
    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }
}