package com.iAxis.jumghor.relation_service.controller;

import com.iAxis.jumghor.entities.dto.ContactRequestDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.ContactRequest;
import com.iAxis.jumghor.relation_service.proxy.UserProxy;
import com.iAxis.jumghor.relation_service.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.iAxis.jumghor.utils.collection.CollectionUtils.isAnyNull;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@RestController
@RequestMapping("/v1/cr")
public class ContactRequestController {

    private final UserProxy userProxy;

    private final ContactRequestService contactRequestService;

    public ContactRequestController(@Autowired UserProxy userProxy, @Autowired ContactRequestService contactRequestService) {
        this.userProxy = userProxy;
        this.contactRequestService = contactRequestService;
    }

    // todo: remove - added for testing feign
    @GetMapping("/u/{user_id}")
    public UserDto getUserById(@PathVariable("user_id") Long userId) {
        return userProxy.getUser(userId);
    }

    @PostMapping("/{user1_id}/r/{user2_id}")
    public ContactRequestDto contactRequest(@PathVariable long user1_id, @PathVariable long user2_id) {
        UserDto user1Dto = userProxy.getUser(user1_id);
        UserDto user2Dto = userProxy.getUser(user2_id);

        if (isAnyNull(user1Dto, user2Dto)) {
            return null;
        }

        ContactRequest contactRequest = new ContactRequest(user1_id, user2_id);

        contactRequest = contactRequestService.saveOrUpdate(contactRequest);

        return new ContactRequestDto(contactRequest, user1Dto, user2Dto);
    }

//    @GetMapping("/all")
//    public List<ContactRequestDto> getAll() {
//
//    }

}
