package com.link.linkconverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class LinkResponse {
    private String deepLink;
    private String webUrl;
}
