package com.iAxis.jumghor.entities.entity;


import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

import static com.iAxis.jumghor.entities.utils.EntityUtils.isValidIdentifier;

/**
 * @author aditya.chakma
 * @since 09 Mar, 2025
 */
@Table
@Entity(name = "post")
public class Post extends Persistent<Long> {

    public static final int MAX_POST_DETAILS = 30000;

    @Id
    private Long id;

    @NotBlank
    @Size(max = MAX_POST_DETAILS)
    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "likes", nullable = false)
    private int likes;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentsList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public boolean isNew() {
        return isValidIdentifier(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post that = (Post) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
