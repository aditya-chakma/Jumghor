package com.iAxis.jumghor.relation_service.controller;

import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.ContactId;
import com.iAxis.jumghor.entities.entity.ContactRequest;
import com.iAxis.jumghor.entities.entity.User;
import com.iAxis.jumghor.relation_service.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
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

    private UserProxy userProxy;

    public ContactRequestController(@Autowired UserProxy userProxy) {
        this.userProxy = userProxy;
    }


    @PostMapping("/{user1}/r/{user2}")
    public void contactRequest(@PathVariable long user1_id, @PathVariable long user2_id) {
        UserDto user1Dto = userProxy.getUser(user1_id);
        UserDto user2Dto = userProxy.getUser(user2_id);

        // check if already friends
        User user1 = user1Dto.toUser();
        User user2 = user2Dto.toUser();

        ContactRequest contactRequest = new ContactRequest(user1, user2);

    }

}
