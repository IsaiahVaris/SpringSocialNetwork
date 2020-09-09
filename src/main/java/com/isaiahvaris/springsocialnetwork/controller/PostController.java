package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.serviceImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @PostMapping("/")
    public String showPosts(Model model) {
        model.addAttribute("allposts", postService.getPosts());
        model.addAttribute("post", new Post());

        return "index";
    }

    @PostMapping("/profile")
    public String showUserPosts(Model model) {

        User user = LoginController.currentUser;
        model.addAttribute("allUserPosts", postService.getPostsByUser(user));
        model.addAttribute("post", new Post());

        return "profile";
    }

    @PostMapping("/newpost")
    public String newPost(@ModelAttribute(name = "post") Post post, BindingResult result, Model model) {
        postService.addPost(post);
        return "redirect:/";
    }

    @PostMapping("/editpost/{id}")
    public String editPost(@PathVariable("id") int id, @ModelAttribute(name = "post") Post post, String messageBody, BindingResult result,
                           Model model) {

        postService.editPost(post, messageBody);
        return "index";
    }

    @PostMapping("/likepost/{id}")
    public String likePost(@PathVariable("id") int id, @ModelAttribute(name = "post") Post post, BindingResult result,
                           Model model) {
        return "index";

    }

    @PostMapping("/deletepost/{id}")
    public String deletePost(@PathVariable("id") int id, @ModelAttribute(name = "post") Post post, Model model) {

        postService.deletePost(post);
        return "index";
    }
}