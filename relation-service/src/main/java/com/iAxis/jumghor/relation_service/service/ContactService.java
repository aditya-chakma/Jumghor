package com.iAxis.jumghor.relation_service.service;

import com.iAxis.jumghor.relation_service.entity.Contact;
import com.iAxis.jumghor.relation_service.entity.ContactRequest;
import com.iAxis.jumghor.entities.interfaces.EntityStatus;
import com.iAxis.jumghor.relation_service.repository.ContactRepository;
import com.iAxis.jumghor.relation_service.repository.ContactRequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    private final ContactRequestRepository contactRequestRepository;

    public ContactService(@Autowired ContactRepository contactRepository, @Autowired ContactRequestRepository contactRequestRepository) {
        this.contactRepository = contactRepository;
        this.contactRequestRepository = contactRequestRepository;
    }

    @Transactional
    public Contact save(Contact contact) {
        // mark the request as deactivate first
        ContactRequest contactRequest = contactRequestRepository.findByFromAndTo(contact.getId().getUser1(), contact.getId().getUser2());
        contactRequest.setStatus(EntityStatus.COMPLETED);
        contactRequestRepository.save(contactRequest);

        return contactRepository.save(contact);
    }

}
