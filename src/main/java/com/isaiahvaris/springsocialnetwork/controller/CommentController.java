package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.service.CommentService;
import com.isaiahvaris.springsocialnetwork.serviceImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
public class CommentController {

    PostServiceImpl postService;
    CommentService commentService;

    public CommentController(PostServiceImpl postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    //new comment on a post form home page
    @PostMapping("/new/{id}")
    public String newCommentIndex(@PathVariable("id") int id, HttpSession session, @Valid Comment comment) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        comment.setPost(postService.getPostById(id));
        comment.setUser((User) userObj);
        commentService.addComment(comment);

        return "redirect:/";
    }

    //new comment on a post form post page
    @PostMapping("/post/new/{id}")
    public String newCommentPost(@PathVariable("id") int id, HttpSession session, @Valid Comment comment) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        comment.setPost(postService.getPostById(id));
        comment.setUser((User) userObj);
        commentService.addComment(comment);
        return "redirect:/post/{id}";
    }
}
