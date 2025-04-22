package com.iAxis.jumghor.repository;

import com.iAxis.jumghor.entities.entity.Post;
import com.iAxis.jumghor.entities.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 10:48 AM
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> getAllByUser(User user);

}
