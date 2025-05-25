package com.iAxis.jumghor.post.repository;

import com.iAxis.jumghor.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 10:48 AM
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userId = :user_id")
    List<Post> findAllByUserId(Long user_id);

}
