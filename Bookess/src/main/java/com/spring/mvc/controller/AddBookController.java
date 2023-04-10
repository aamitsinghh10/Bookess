package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AddBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public String addBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addPostBookPage(Model model, @Valid @ModelAttribute("book") Book book,
                                  BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }
        try {
            bookService.addBook(book);
            return "redirect:/dashboard";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Error occurred while adding book: " + e.getMessage());
            Book existingBook = bookService.findByIsbn(book.getIsbn());
            if (existingBook != null) {
                model.addAttribute("existingBook", existingBook);
            }
            return "addBook";
        }
    }

}
