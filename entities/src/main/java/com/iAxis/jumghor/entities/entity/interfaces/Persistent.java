package com.iAxis.jumghor.entities.entity.interfaces;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

import static com.iAxis.jumghor.entities.utils.EntityUtils.isValidIdentifier;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 2:25 PM
 */
@MappedSuperclass
public abstract class Persistent<T> {

    @NotNull
    @CreatedDate
    @Column(name = "created", nullable = false)
    private LocalDate created;

    @NotNull
    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    private LocalDate updated;

    @Column(name = "status")
    private int status;

    @Version
    private long version;

    public abstract T getId();

    public abstract void setId(T id);

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public abstract boolean isNew();

}
