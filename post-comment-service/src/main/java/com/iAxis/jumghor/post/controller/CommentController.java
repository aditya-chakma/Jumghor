package com.iAxis.jumghor.post.controller;

import com.iAxis.jumghor.entities.dto.CommentDto;
import com.iAxis.jumghor.entities.dto.UserDto;
import com.iAxis.jumghor.entities.entity.Comment;
import com.iAxis.jumghor.entities.entity.Post;
import com.iAxis.jumghor.post.proxy.UserProxy;
import com.iAxis.jumghor.post.service.CommentService;
import com.iAxis.jumghor.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 1:59 PM
 */
@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    private final CommentService commentService;

    private final PostService postService;

    private final UserProxy userProxy;

    public CommentController(@Autowired CommentService commentService,
                             @Autowired PostService postService,
                             @Autowired UserProxy userProxy) {

        this.commentService = commentService;
        this.postService = postService;
        this.userProxy = userProxy;
    }

    @GetMapping("/all/{post_id}")
    public List<CommentDto> getAllComments(@PathVariable("post_id") long post_id) {

        Post post = postService.findById(post_id);

        if (Objects.isNull(post)) {
            return null;
        }

        return commentService.findAllCommentByPost(post_id).stream().map(
                comment -> {
                    UserDto userDto = userProxy.getUser(comment.getUserId()); // add try catch here. handle
                    return new CommentDto(comment, userDto);
                }
        ).toList();
    }

    @PostMapping("/{post_id}")
    public CommentDto create(@RequestBody CommentDto commentDto,
                             @PathVariable("post_id") Long postId) {

        Post post = postService.findById(postId);

        if (Objects.isNull(post)) {
            return null;
        }

        Comment comment = commentDto.toComment();
        comment.setPostId(postId);

        commentService.save(comment);

        UserDto userDto = userProxy.getUser(comment.getUserId());

        return new CommentDto(comment, userDto);
    }

    

}
