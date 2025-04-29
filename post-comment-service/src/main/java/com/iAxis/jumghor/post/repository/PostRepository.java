package com.iAxis.jumghor.post.repository;

import com.iAxis.jumghor.entities.entity.Post;
import com.iAxis.jumghor.entities.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 10:48 AM
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getAllByUser(User user);

}
