package com.spring.mvc.controller;

import com.spring.mvc.entity.ReadLaterBooks;
import com.spring.mvc.service.ReadLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReadLaterController {
    @Autowired
    private ReadLaterService readLaterService;

    @GetMapping("/readLater")
    public String getReadLaterBooks(Model model) {
        List<ReadLaterBooks> readLaterBooks = readLaterService.getReadLaterBooks();
        model.addAttribute("readLaterBooks", readLaterBooks);
        return "readLater";
    }
}