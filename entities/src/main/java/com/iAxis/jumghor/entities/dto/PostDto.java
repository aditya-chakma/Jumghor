package com.iAxis.jumghor.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iAxis.jumghor.entities.entity.Post;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 10:48 AM
 */
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String details;

    private int likes;

    @JsonProperty("user")
    private UserDto userDto;

    public PostDto() {}

    public PostDto(Post post) {
        this.details = post.getDetails();
        this.likes = post.getLikes();
        this.userDto = new UserDto(post.getUser());
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
