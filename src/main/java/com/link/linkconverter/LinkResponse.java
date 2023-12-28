package com.link.linkconverter;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LinkResponse {
    private String deepLink;
    private String webUrl;
}
