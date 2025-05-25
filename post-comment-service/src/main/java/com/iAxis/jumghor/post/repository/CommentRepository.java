package com.iAxis.jumghor.post.repository;

import com.iAxis.jumghor.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 2:01 PM
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.postId = :post_id")
    List<Comment> findByPostId(long post_id);

}
