package com.iAxis.jumghor.post.service;

import com.iAxis.jumghor.entities.entity.Comment;
import com.iAxis.jumghor.post.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aditya.chakma
 * @since 15 May, 2025 1:43 PM
 */
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(@Autowired CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findAllCommentByPost(Long post_id) {
        return commentRepository.findByPostId(post_id);
    }

}
