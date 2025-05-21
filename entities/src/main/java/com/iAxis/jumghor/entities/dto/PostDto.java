package com.iAxis.jumghor.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 10:48 AM
 */
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String details;

    private int likes;

    @JsonProperty("user")
    private UserDto userDto;

    public PostDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

}
