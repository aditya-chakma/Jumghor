package com.iAxis.jumghor.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iAxis.jumghor.entities.entity.Comment;

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

    @JsonProperty(value = "", access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;

    @JsonProperty("user")
    private UserDto userDto;

    public CommentDto() {
    }

    public CommentDto(Comment comment, UserDto userDto) {
        this.comment = comment.getComment();
        this.userDto = userDto;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Comment toComment() {
        Comment comment = new Comment();

        comment.setComment(this.comment);
        comment.setUserId(this.userId);

        return comment;
    }

}
