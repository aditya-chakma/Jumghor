package com.iAxis.jumghor.post.controller;

import com.iAxis.jumghor.entities.dto.PostDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.post.entity.Post;
import com.iAxis.jumghor.post.proxy.UserProxy;
import com.iAxis.jumghor.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author aditya.chakma
 * @since 09 Mar, 2025
 */
@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    private final UserProxy userProxy;

    public PostController(@Autowired PostService postService, @Autowired UserProxy userProxy) {
        this.postService = postService;
        this.userProxy = userProxy;

    }

    @GetMapping
    public List<PostDto> getALlPosts(@RequestParam("user-id") long user_id) {
        UserDto userDto = userProxy.getUser(user_id);

        if (Objects.isNull(userDto)) {
            return null;
        }

        List<Post> userPostList = postService.findAllByUser(user_id);

        return userPostList.stream()
                .map(p -> p.to(userDto))
                .collect(Collectors.toList());
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto,
                              @RequestParam("user-id") Long userId) {

        UserDto userDto = userProxy.getUser(userId);

        if (Objects.isNull(userDto)) {
            return null;
        }

        Post post = Post.from(postDto);
        post.setUserId(userId);
        post.setLikes(0);

        postService.save(post);

        return post.to(userDto);
    }

    @PatchMapping("/{post_id}")
    public PostDto updatePost(@RequestBody PostDto postDto,
                              @PathVariable("post_id") Long post_id) {

        Post oldPost = postService.findById(post_id);

        if (Objects.isNull(oldPost)) {
            return null;
        }

        oldPost.setDetails(postDto.getDetails());
        oldPost.setLikes(postDto.getLikes());
        oldPost = postService.save(oldPost);

        UserDto userDto = userProxy.getUser(oldPost.getUserId());

        return oldPost.to(userDto);
    }

}
