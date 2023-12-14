package com.example.LinkConverter.controller;

import com.example.LinkConverter.service.LinkConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
public class LinkConverterController {
    private final LinkConverterService service;
    @PostMapping("/webUrl-to-deeplink")
    public String convertWebUrlToDeeplink(@RequestBody  String webUrl) {
        return service.convertWebUrlToDeeplink(webUrl);

    }
}