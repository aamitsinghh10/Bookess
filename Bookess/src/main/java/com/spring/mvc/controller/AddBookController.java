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
import java.util.List;

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
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model, HttpServletRequest request) {
        if(result.hasErrors()){
            return "addBook";
        }
        Book existingBook = bookService.findByIsbn(book.getIsbn());
        if (existingBook != null) {
            model.addAttribute("errorMessage", "Book already exists in the database!");
        } else {
            bookService.addBook(book);
            model.addAttribute("successMessage", "Book added successfully!");
        }
        return "redirect:dashboard";
    }


}
