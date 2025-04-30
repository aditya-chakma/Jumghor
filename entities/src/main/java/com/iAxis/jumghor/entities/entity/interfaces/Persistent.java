package com.iAxis.jumghor.entities.entity.interfaces;

import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 2:25 PM
 */
@MappedSuperclass
public abstract class Persistent {

    @Id
    @SnowflakeSequence
    private Long id;

    @NotNull
    @CreatedDate
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @NotNull
    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "status")
    private int status;

    @Version
    private long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
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

}
