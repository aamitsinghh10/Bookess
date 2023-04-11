package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.LikedBooks;
import com.spring.mvc.entity.ReadLaterBooks;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.ReadLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ReadLaterController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReadLaterService readLaterService;

    @GetMapping("/readLater")
    public String showReadLaterBooks(Model model) {
        List<ReadLaterBooks> readLaterBooks = readLaterService.getReadLaterBooks();
        model.addAttribute("readLater", readLaterBooks);
        return "readLater";
    }


    @PostMapping("/readLater")
    public String addPostReadLaterBook(HttpServletRequest request, Model model)
    {
        String isbn = request.getParameter("isbn");
        if (!readLaterService.bookExists(isbn))
        {
            Book book = bookService.getBookByIsbn(isbn);

            if (book != null) { // add null check here
                ReadLaterBooks readLaterBooks = new ReadLaterBooks();
                readLaterBooks.setTitle(book.getTitle());
                readLaterBooks.setAuthor(book.getAuthor());
                readLaterBooks.setIsbn(book.getIsbn());
                readLaterBooks.setGenre(book.getGenre());
                readLaterBooks.setDescription(book.getDescription());
                readLaterBooks.setRating(book.getRating());
                readLaterBooks.setPrice(book.getPrice());
                readLaterBooks.setCoverImage(book.getCoverImage());

                System.out.println("Add Read Later Books");
                readLaterService.addReadLaterBooks(readLaterBooks);
            } else {
                model.addAttribute("errorMessage", "Book not found"); // Set an error message in the model
            }
        } else {
            model.addAttribute("errorMessage", "Book already liked"); // Set an error message in the model
        }
        return "redirect:/readLater";
    }

}
