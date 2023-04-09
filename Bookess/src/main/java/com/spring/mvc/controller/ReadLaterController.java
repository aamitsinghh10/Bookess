package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.ReadLaterBooks;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.ReadLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReadLaterController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReadLaterService readLaterService;

    @GetMapping("/readLater")
    public String showReadLaterPage(Model model) {
        List<ReadLaterBooks> readLaterBooks = readLaterService.getReadLaterBooks();
        model.addAttribute("readLaterBooks", readLaterBooks);
        return "readLater";
    }

    @PostMapping("/readLater")
    public String addToReadLater(@RequestParam("bookId") int bookId, Model model) {
        try {
            Book book = bookService.getBookById(bookId);

            if (book != null) {
                ReadLaterBooks readLater = new ReadLaterBooks();
                readLater.setTitle(book.getTitle());
                readLater.setAuthor(book.getAuthor());
                readLater.setIsbn(book.getIsbn());
                readLater.setCoverImage(book.getCoverImage());
                readLater.setDescription(book.getDescription());
                readLater.setGenre(book.getGenre());
                readLater.setRating(book.getRating());
                readLater.setPrice(book.getPrice());
                readLaterService.addReadLaterBooks(readLater);
                model.addAttribute("message", "Book added to Read Later list.");
            } else {
                model.addAttribute("error", "Book not found.");
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while adding the book to Read Later list.");
        }
        return "redirect:/dashboard";
    }
}
