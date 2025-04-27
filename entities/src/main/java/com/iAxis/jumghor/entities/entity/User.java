package com.iAxis.jumghor.entities.entity;


import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 2:23 PM
 */
@Table
@Entity(name = "app_user")
public class User extends Persistent {

    public static final int USERNAME_MAX_SIZE = 15;
    public static final int DISPLAYNAME_MAX_SIZE = 64;
    public static final int EMAIL_ADDRESS_MAX_SIZE = 254;
    public static final int PASSWORD_HASH_MAX_SIZE = 256;

    public static final String CACHE_NAME = "user";

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

    @NotBlank
    @Size(max = PASSWORD_HASH_MAX_SIZE)
    @Column(name = "password_hash", nullable = false)
    private String password;

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

}
