package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.LikedBooks;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/liked")
public class LikedController {

    @Autowired
    private LikedService likedService;

    @GetMapping("/liked")
    public ModelAndView likedBooks() {
        List<LikedBooks> likedBooks = likedService.getLikedBooks();
        ModelAndView mav = new ModelAndView("liked-books");
        mav.addObject("likedBooks", likedBooks);
        return mav;
    }

}