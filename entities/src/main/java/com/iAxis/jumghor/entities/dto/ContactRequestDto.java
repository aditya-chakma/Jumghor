package com.iAxis.jumghor.entities.dto;

import com.iAxis.jumghor.entities.entity.ContactRequest;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
public class ContactRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    private UserDto fromUser;

    private UserDto toUser;

    private LocalDateTime created;

    public ContactRequestDto() {
    }

    public ContactRequestDto(ContactRequest contactRequest, UserDto fromUser, UserDto toUser) {
        this.id = contactRequest.getId();
        this.created = contactRequest.getCreated();
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDto getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserDto fromUser) {
        this.fromUser = fromUser;
    }

    public UserDto getToUser() {
        return toUser;
    }

    public void setToUser(UserDto toUser) {
        this.toUser = toUser;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
