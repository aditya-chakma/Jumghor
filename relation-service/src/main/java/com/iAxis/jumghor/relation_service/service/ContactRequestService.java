package com.iAxis.jumghor.relation_service.service;

import com.iAxis.jumghor.relation_service.entity.ContactRequest;
import com.iAxis.jumghor.relation_service.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ContactRequest> findAll() {
        return contactRequestRepository.findAll();
    }

    public ContactRequest saveOrUpdate(ContactRequest contactRequest) {
        return contactRequestRepository.save(contactRequest);
    }

}
