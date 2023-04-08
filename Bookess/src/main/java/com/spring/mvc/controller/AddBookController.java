package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String addBook(@ModelAttribute("book") Book book, Model model, HttpServletRequest request) {
        List<Book> bookList = bookService.getAllBooks();
        boolean bookExists = false;
        for (Book existingBook : bookList) {
            if (existingBook.getTitle().equals(book.getTitle()) && existingBook.getAuthor().equals(book.getAuthor())) {
                bookExists = true;
                break;
            }
        }
        if (bookExists) {
            model.addAttribute("errorMessage", "Book already exists in the database!");
        } else {
            bookService.addBook(book);
            model.addAttribute("successMessage", "Book added successfully!");
        }
        return "dashboard";
    }
}