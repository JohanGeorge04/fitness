package com.fitness.platform.controller;

import com.fitness.platform.entity.User;
import com.fitness.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showIndex() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user) {
        if (userService.loginUser(user)) {
            return "redirect:/dashboard";
        }
        return "redirect:/login?logsuccess=false";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        try {
            userService.registerUser(user);
            return "redirect:/login?success=true";
        } catch (IllegalArgumentException e) {
            return "redirect:/login?success=false";
        }
    }
}
