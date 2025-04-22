package com.iAxis.jumghor.comment.repository;

import com.iAxis.jumghor.entities.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 2:01 PM
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPostId(long post_id);

}
