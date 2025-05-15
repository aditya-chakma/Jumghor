package com.iAxis.jumghor.entities.entity;

import com.iAxis.jumghor.entities.annotations.SnowflakeSequence;
import com.iAxis.jumghor.entities.entity.interfaces.Persistent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 12:24 PM
 */
@Entity
@Table(name = "comment")
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
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "post_id", nullable = false)
    private Long postId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
