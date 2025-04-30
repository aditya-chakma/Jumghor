package com.iAxis.jumghor.relation_service.repository;

import com.iAxis.jumghor.entities.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {

    @Query("SELECT cr FROM ContactRequest cr WHERE (cr.fromId = :from AND cr.toId = :to) OR (cr.fromId = :to AND cr.toId = :from)")
    ContactRequest findByFromAndTo(Long from, Long to);

}
