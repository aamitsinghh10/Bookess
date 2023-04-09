package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPostPage(String username, String email, String password, String confirm_password, Model model) {
        // validate the username, email, and password fields
        if (username == null || username.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            model.addAttribute("error", "Please fill in all required fields.");
            return "register";
        }

        // validate the password confirmation
        if (!password.equals(confirm_password)) {
            model.addAttribute("error", "Passwords don't match.");
            return "register";
        }

        try {
            // create new user object and set its properties
            User user = new User();
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);

            // register new user and redirect to login page
            userService.registerUser(user);
            return "redirect:login";
        } catch (Exception e) {
            // handle any exceptions that may occur during registration
            model.addAttribute("error", "An error occurred while registering. Please try again later.");
            return "register";
        }
    }
}
