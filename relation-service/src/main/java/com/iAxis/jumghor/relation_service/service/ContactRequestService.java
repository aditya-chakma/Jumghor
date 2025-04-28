package com.iAxis.jumghor.relation_service.service;

import com.iAxis.jumghor.entities.entity.ContactRequest;
import com.iAxis.jumghor.relation_service.repository.ContactRequestRepository;
import com.iAxis.jumghor.utils.security.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@Service
public class ContactRequestService {

    // todo: get serverId from application properties with @Value annotation
    private final int serverId = 101;

    private final ContactRequestRepository contactRequestRepository;

    public ContactRequestService(@Autowired ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public ContactRequest save(ContactRequest contactRequest) {
        contactRequest.setId(RandomGenerator.init().randomUUID(serverId));
        contactRequest.setCreated(LocalDateTime.now());
        contactRequest.setUpdated(LocalDateTime.now());

        return contactRequestRepository.save(contactRequest);
    }

}
