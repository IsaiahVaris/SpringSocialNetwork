package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.Like;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.service.PostService;
import com.isaiahvaris.springsocialnetwork.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
    PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    //get mapping for populating home page
    @GetMapping("/")
    public String getPosts(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";

        model.addAttribute("user", (User) userObj);

        model.addAttribute("posts", postService.getPosts());


        model.addAttribute("newpost", new Post());
        model.addAttribute("newcomment", new Comment());
        model.addAttribute("newlike", new Like());

        return "index";
    }
}
