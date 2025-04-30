package com.iAxis.jumghor.entities.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 30 Apr, 2025
 */
public class ContactDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long user1Id;

    private Long user2Id;

    private LocalDateTime createdAt;

    public ContactDto() {
    }

    public ContactDto(Long user1Id, Long user2Id, LocalDateTime createdAt) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.createdAt = createdAt;
    }

    public Long getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Long user1Id) {
        this.user1Id = user1Id;
    }

    public Long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Long user2Id) {
        this.user2Id = user2Id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
