package com.iAxis.jumghor.entities.entity;

import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 12:24 PM
 */
@Table
@Entity(name = "comment")
public class Comment extends Persistent<Long> {

    public static final int MAX_COMMENT_SIZE = 4000;

    @Id
    @SnowflakeSequence
    private Long id;

    @NotBlank
    @Size(max = MAX_COMMENT_SIZE)
    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "likes", nullable = false)
    private int likes;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
