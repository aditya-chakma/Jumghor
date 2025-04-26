package com.iAxis.jumghor.controller;

import com.iAxis.jumghor.entities.dto.PostDto;
import com.iAxis.jumghor.entities.entity.User;
import com.iAxis.jumghor.repository.PostRepository;
import com.iAxis.jumghor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aditya.chakma
 * @since 09 Mar, 2025
 */
@RestController
@RequestMapping("/p")
public class PostController {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public PostController(@Autowired PostRepository postRepository, @Autowired UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all/{user_id}")
    public List<PostDto> getALlPosts(@PathVariable("user_id") long user_id) {
        User user = userRepository.findById(user_id).get();
        return postRepository.getAllByUser(user).stream().map(PostDto::new).collect(Collectors.toList());
    }

}
