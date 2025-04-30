package com.iAxis.jumghor.relation_service.repository;

import com.iAxis.jumghor.entities.entity.Contact;
import com.iAxis.jumghor.entities.entity.ContactId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, ContactId> {
}
