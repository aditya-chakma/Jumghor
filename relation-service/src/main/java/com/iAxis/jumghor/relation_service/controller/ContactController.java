package com.iAxis.jumghor.relation_service.controller;

import com.iAxis.jumghor.entities.dto.ContactDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.Contact;
import com.iAxis.jumghor.entities.entity.ContactId;
import com.iAxis.jumghor.relation_service.proxy.UserProxy;
import com.iAxis.jumghor.relation_service.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.iAxis.jumghor.utils.collection.CollectionUtils.isAnyNull;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@RestController
@RequestMapping("/v1/c")
public class ContactController {

    private final UserProxy userProxy;

    private final ContactService contactService;

    public ContactController(@Autowired UserProxy userProxy, @Autowired ContactService contactService) {
        this.userProxy = userProxy;
        this.contactService = contactService;
    }

    @PostMapping("/{user1_id}/add/{user2_id}")
    public ContactDto createContact(@PathVariable Long user1_id, @PathVariable Long user2_id) {
        UserDto user1 = userProxy.getUser(user1_id);
        UserDto user2 = userProxy.getUser(user2_id);

        if (isAnyNull(user1, user2)) {
            return null;
        }

        ContactId contactId = new ContactId(user1_id, user2_id);
        Contact contact = new Contact();
        contact.setId(contactId);

        contact = contactService.save(contact);

        return new ContactDto(user1_id, user1_id, contact.getCreated());
    }

}
