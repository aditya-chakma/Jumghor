package com.iAxis.jumghor.relation_service.entity;

import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import com.iAxis.jumghor.entities.dto.ContactRequestDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * @author aditya.chakma
 * @since 27 Apr, 2025
 */
@Entity
@Table(name = "contact_request")
public class ContactRequest extends Persistent<Long> {

    @Id
    @SnowflakeSequence
    private Long id;

    @NotNull
    @Column(name = "from_id", updatable = false, nullable = false)
    private Long fromId;

    @NotNull
    @Column(name = "to_id", updatable = false, nullable = false)
    private Long toId;

    public ContactRequest() {
    }

    public ContactRequest(Long fromId, Long toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public static ContactRequest from(ContactRequestDto contactRequestDto) {
        ContactRequest contactRequest = new ContactRequest();

        contactRequest.setId(contactRequestDto.getId());
        contactRequest.setFromId(contactRequestDto.getFromUser().getId());
        contactRequest.setToId(contactRequestDto.getToUser().getId());

        return contactRequest;
    }

    public ContactRequestDto to(UserDto from, UserDto to) {
        ContactRequestDto contactRequestDto = new ContactRequestDto();

        contactRequestDto.setId(getId());
        contactRequestDto.setFromUser(from);
        contactRequestDto.setToUser(to);
        contactRequestDto.setCreated(getCreated());

        return contactRequestDto;
    }

}
