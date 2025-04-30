package com.iAxis.jumghor.entities.entity;

import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 28 Apr, 2025
 */
@Entity
@Table(name = "contact")
public class Contact extends Persistent<ContactId> {

    @EmbeddedId
    private ContactId id;

    public ContactId getId() {
        return id;
    }

    public void setId(ContactId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact that = (Contact) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
