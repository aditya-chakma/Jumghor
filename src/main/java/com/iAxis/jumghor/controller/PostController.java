package com.iAxis.jumghor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 09 Mar, 2025
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!! Serving from Spring Boot!";
    }

}
