package com.iAxis.jumghor.entities.entity.interfaces;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 2:25 PM
 */
@MappedSuperclass
public abstract class Persistent {

    @Id
    private long id;

    @NotNull
    @CreatedDate
    @Column(name = "created", nullable = false)
    private LocalDate created;

    @NotNull
    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    private LocalDate updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
