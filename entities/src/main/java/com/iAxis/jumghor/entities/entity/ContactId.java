package com.iAxis.jumghor.entities.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@Embeddable
public class ContactId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "user1", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2", nullable = false)
    private User user2;

    public ContactId() {
    }

    public ContactId(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }
}
