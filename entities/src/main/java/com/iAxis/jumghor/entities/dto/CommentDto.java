package com.iAxis.jumghor.entities.dto;

import com.iAxis.jumghor.entities.entity.User;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 1:24 PM
 */
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String comment;

    private User user;

    public CommentDto() {
    }

    public CommentDto(String comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
