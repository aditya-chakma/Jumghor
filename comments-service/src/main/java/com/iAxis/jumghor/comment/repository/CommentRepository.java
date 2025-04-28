package com.iAxis.jumghor.comment.repository;

import com.iAxis.jumghor.entities.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 2:01 PM
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostId(long post_id);

}
