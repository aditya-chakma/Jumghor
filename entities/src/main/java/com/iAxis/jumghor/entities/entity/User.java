package com.iAxis.jumghor.entities.entity;


import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import com.iAxis.jumghor.utils.security.SecurityUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

import static com.iAxis.jumghor.entities.utils.EntityUtils.isValidIdentifier;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 2:23 PM
 */
@Table
@Entity(name = "app_user")
public class User extends Persistent<Long> {

    public static final int USERNAME_MAX_SIZE = 15;
    public static final int DISPLAYNAME_MAX_SIZE = 64;
    public static final int EMAIL_ADDRESS_MAX_SIZE = 254;
    public static final int PASSWORD_HASH_MAX_SIZE = 256;

    public static final String CACHE_NAME = "app_user";

    @Id
    @SnowflakeSequence
    private Long id;

    @NotBlank
    @Size(max = USERNAME_MAX_SIZE)
    @Column(name = "user_name", unique = true, nullable = false, updatable = false)
    private String userName;

    @NotBlank
    @Size(max = DISPLAYNAME_MAX_SIZE)
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Email
    @NotBlank
    @Size(max = EMAIL_ADDRESS_MAX_SIZE)
    @Column(name = "email", nullable = false)
    private String email;

    @Transient
    private String password;

    @NotBlank
    @Size(max = PASSWORD_HASH_MAX_SIZE)
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNew() {
        return !isValidIdentifier(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    private String getPasswordHash() {
        return passwordHash;
    }

    private void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @PrePersist
    private void prePersist() {
        setPasswordHash(SecurityUtils.encryptPassword(getPassword()));
    }

}
