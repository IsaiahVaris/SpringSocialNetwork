package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.Comment;
import com.isaiahvaris.springsocialnetwork.model.Like;
import com.isaiahvaris.springsocialnetwork.model.Post;
import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {
    PostService postService;

    public ProfileController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/profile")
    public String getPosts(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj == null) return "redirect:/auth/login";
        model.addAttribute("user", (User) userObj);
        model.addAttribute("userposts", postService.getPostsByUser((User) userObj));
        model.addAttribute("newpost", new Post());
        model.addAttribute("postupdate", new Post());
        model.addAttribute("postdelete", new Post());
        model.addAttribute("newcomment", new Comment());
        model.addAttribute("newpostlike", new Like());
        return "profile";
    }


}
