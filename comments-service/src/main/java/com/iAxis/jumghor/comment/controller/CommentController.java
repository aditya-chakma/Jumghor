package com.iAxis.jumghor.comment.controller;

import com.iAxis.jumghor.comment.repository.CommentRepository;
import com.iAxis.jumghor.entities.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 24 Apr, 2025 1:59 PM
 */
@RestController
@RequestMapping("/c")
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(@Autowired CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/all/{post_id}")
    public List<CommentDto> getAllComments(@PathVariable("post_id") long post_id) {
        return commentRepository.findByPostId(post_id)
                .stream()
                .map(comment -> new CommentDto(comment.getComment(), comment.getUser()))
                .toList();
    }
}
