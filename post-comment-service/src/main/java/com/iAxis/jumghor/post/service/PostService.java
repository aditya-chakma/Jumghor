package com.iAxis.jumghor.post.service;

import com.iAxis.jumghor.entities.entity.Post;
import com.iAxis.jumghor.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 15 May, 2025 1:06 PM
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllByUser(Long user_id) {
        return postRepository.findAllByUserId(user_id);
    }

    public Post findById(Long post_id) {
        return postRepository.findById(post_id).orElse(null);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

}
