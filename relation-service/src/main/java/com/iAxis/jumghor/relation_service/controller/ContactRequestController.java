package com.iAxis.jumghor.relation_service.controller;

import com.iAxis.jumghor.entities.dto.ContactRequestDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.relation_service.entity.ContactRequest;
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
@RequestMapping("/v1/contact-requests")
public class ContactRequestController {

    private final UserProxy userProxy;

    private final ContactRequestService contactRequestService;

    public ContactRequestController(@Autowired UserProxy userProxy, @Autowired ContactRequestService contactRequestService) {
        this.userProxy = userProxy;
        this.contactRequestService = contactRequestService;
    }

    @PostMapping("/from/{user1_id}/to/{user2_id}")
    public ContactRequestDto contactRequest(@PathVariable long user1_id, @PathVariable long user2_id) {
        UserDto user1Dto = userProxy.getUser(user1_id);
        UserDto user2Dto = userProxy.getUser(user2_id);

        if (isAnyNull(user1Dto, user2Dto)) {
            return null;
        }

        ContactRequest contactRequest = new ContactRequest(user1_id, user2_id);

        contactRequest = contactRequestService.saveOrUpdate(contactRequest);

        return contactRequest.to(user1Dto, user2Dto);
    }

//    @GetMapping("/all")
//    public List<ContactRequestDto> getAll() {
//
//    }

}
