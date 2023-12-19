package com.example.LinkConverter;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@ResponseBody
public class LinkConverterController {
    private final LinkConverterService service;
    @PostMapping("/webUrl-to-deeplink")
    public LinkResponse convertWebUrlToDeeplink(@RequestBody  String webUrl) {
        return service.convertWebUrlToDeeplink(webUrl);

    }
}