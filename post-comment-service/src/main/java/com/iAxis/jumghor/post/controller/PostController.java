package com.iAxis.jumghor.post.controller;

import com.iAxis.jumghor.post.repository.PostRepository;
import com.iAxis.jumghor.entities.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 09 Mar, 2025
 */
@RestController
@RequestMapping("/p")
public class PostController {

    private final PostRepository postRepository;

    public PostController(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @GetMapping("/all/{user_id}")
    public List<PostDto> getALlPosts(@PathVariable("user_id") long user_id) {
//        User user = userRepository.findById(user_id).get();
//        return postRepository.getAllByUser(user).stream().map(PostDto::new).collect(Collectors.toList());

        return null;
    }

}
