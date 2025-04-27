package com.iAxis.jumghor.entities.entity;

import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * @author aditya.chakma
 * @since 27 Apr, 2025
 */
@Entity
@Table(name = "contact_request")
public class ContactRequest extends Persistent {

    @NotNull
    @OneToOne
    @JoinColumn(name = "from_id", nullable = false, updatable = false)
    private User fromUser;

    @NotNull
    @OneToOne
    @JoinColumn(name = "to_id", nullable = false, updatable = false)
    private User toUser;

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

}
