package com.iAxis.jumghor.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    private Integer likes;

    @JsonProperty("user")
    private UserDto userDto;

    public CommentDto() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

}
