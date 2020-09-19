package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.Like;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.service.CommentService;
import com.isaiahvaris.springsocialnetwork.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {
    CommentService commentService;
    PostService postService;

    public PostController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    /*
    New post from home page
     */
    @PostMapping("/new")
    public String newPostIndex(HttpSession session, @Valid Post post) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        post.setUser((User) userObj);
        postService.addPost(post);
        return "redirect:/";
    }
    /*
    New post from profile page
     */
    @PostMapping("/profile/new")
    public String newPostProfile(HttpSession session, @Valid Post post) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        post.setUser((User) userObj);
        postService.addPost(post);
        return "redirect:/profile";
    }

    //edit post
    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable("id") int id, HttpSession session, @Valid Post postupdate) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        Post post = postService.getPostById(id);
        postService.editPost(post, postupdate.getMessageBody());
        return "redirect:/profile";
    }

    //delete post
    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        Post post = postService.getPostById(id);
        postService.deletePost(post);
        return "redirect:/profile";
    }

    //get mapping for single post page view
    @GetMapping("/{id}")
    public String viewPost(@PathVariable("id") int id, HttpSession session, Model model) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        Post post = postService.getPostById(id);

        model.addAttribute("user", (User) userObj);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getPostComments(post));
        model.addAttribute("newcomment", new Comment());
        model.addAttribute("newlike", new Like());

        return "post";
    }



}