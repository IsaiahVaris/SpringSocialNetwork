package com.isaiahvaris.springsocialnetwork.service;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;

import java.util.List;

public interface CommentService {
    Comment addComment (Comment comment);
    List<Comment> getPostComments(Post post);
    void deleteComment(Comment comment);

}
