package com.iAxis.jumghor.relation_service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@RestController
@RequestMapping("/v1/cr")
public class ContactRequestController {



    @PostMapping("/{user1}/r/{user2}")
    public void contactRequest(@PathVariable long user1_id, @PathVariable long user2_id) {

    }

}
