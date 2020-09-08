package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.model.User;
import com.isaiahvaris.springsocialnetwork.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

//    @GetMapping("/")
//    public String showUsers(Model model) {
//        model.addAttribute("users", userService.findUser());
//        return "index";
//    }
    @GetMapping("/register")
    public String signUpForm(User user) {
        return "register";
    }


//    @GetMapping("edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userService.findUserById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//
//        model.addAttribute("user", user);
//        return "edituser";
//    }
//    @PostMapping("update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result,
//                             Model model) {
//        if (result.hasErrors()) {
//            user.id=id;
//            return "edituser";
//        }
//
//        userService.saveUser(user);
//        return "redirect:/";
//    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
}