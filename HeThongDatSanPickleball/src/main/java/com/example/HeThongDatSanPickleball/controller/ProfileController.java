package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.User;
import com.example.HeThongDatSanPickleball.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

@GetMapping("/profile")
public String getProfilePage(Model model, Principal principal) {
    String username = principal.getName();
    User user = userService.findByUsername(username);
    model.addAttribute("user", user);
    return "profile";
}
}


