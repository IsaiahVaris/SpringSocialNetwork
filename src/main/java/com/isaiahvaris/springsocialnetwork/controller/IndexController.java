package com.isaiahvaris.springsocialnetwork.controller;

import com.isaiahvaris.springsocialnetwork.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    UserServiceImpl userService;


//    @GetMapping("/")
//    public String showUsers(Model model) {
//        model.addAttribute("users", userService.getUsers());
//        return "index";
//    }
}
