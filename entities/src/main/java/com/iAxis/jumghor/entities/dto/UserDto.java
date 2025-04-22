package com.iAxis.jumghor.entities.dto;


import com.iAxis.jumghor.entities.entity.User;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 22 Apr, 2025 3:18 PM
 */
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String userName;

    private String displayName;

    private String email;

    public UserDto() {}

    public UserDto(User user) {
        this.userName = user.getUserName();
        this.displayName = user.getDisplayName();
        this.email = user.getEmail();
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

}
