package com.iAxis.jumghor.relation_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@Embeddable
public class ContactId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "user1", nullable = false)
    private Long user1;

    @NotNull
    @Column(name = "user2", nullable = false)
    private Long user2;

    public ContactId() {
    }

    public ContactId(Long user1, Long user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Long getUser1() {
        return user1;
    }

    public void setUser1(Long user1) {
        this.user1 = user1;
    }

    public Long getUser2() {
        return user2;
    }

    public void setUser2(Long user2) {
        this.user2 = user2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContactId that = (ContactId) o;
        return Objects.equals(this.user1, that.user1) && Objects.equals(this.user2, that.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }

}
