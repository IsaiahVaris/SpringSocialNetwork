package com.isaiahvaris.springsocialnetwork.serviceImpl;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.repository.CommentRepository;
import com.isaiahvaris.springsocialnetwork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    /*
    Add comment to a post
     */
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /*
    Get all comments for a post
     */
    @Override
    public List<Comment> getPostComments(Post post) {
        return commentRepository.findAllByPost(post);
    }

    /*
    Delete a comment
     */
    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}