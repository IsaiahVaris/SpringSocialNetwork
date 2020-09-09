package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    public static User currentUser;

    @PostMapping("/register")
    public String signUpForm(User user) {
        return "register";
    }

    @GetMapping("/login")
    public String login(User user, Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/loginuser")
    public String loginUser(User user, HttpSession session){
        User user1 = userService.getUserByEmailandPassWord(user.getEmail(), user.getPassWord()).get();
        if(user1 != null ) {
            session.setAttribute("user", user);
            currentUser = user1;
            return "index";
        }
        return "login";
    }

    @PostMapping("/logout")
    public String logoutUser() {
        currentUser = null;
        return "login";
    }

    @PostMapping("adduser")
    public String addUser(@ModelAttribute(name = "user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.addUser(user);
        return "redirect:/";
    }
}