package com.iAxis.jumghor.entities.entity;

import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.*;
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
}
