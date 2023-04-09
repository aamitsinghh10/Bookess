package com.spring.mvc.controller;

import com.spring.mvc.entity.LikedBooks;
import com.spring.mvc.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LikedController {
    @Autowired
    private LikedService likedService;

    @GetMapping("/liked")
    public String showLikedBooks(Model model) {
        List<LikedBooks> likedBooks = likedService.getLikedBooks();
        model.addAttribute("likedBooks", likedBooks);
        return "liked";
    }
}