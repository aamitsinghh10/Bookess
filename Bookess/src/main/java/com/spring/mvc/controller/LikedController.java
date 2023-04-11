package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.entity.LikedBooks;
import com.spring.mvc.service.BookService;
import com.spring.mvc.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LikedController {
    @Autowired
    private LikedService likedService;
    @Autowired
    private BookService bookService;

    @GetMapping("/liked")
    public String showLikedBooks(Model model) {
        List<LikedBooks> likedBooks = likedService.getLikedBooks();
        model.addAttribute("liked", likedBooks);
        return "liked";
    }
    @PostMapping("/liked")
    public String addPostLikedBook(HttpServletRequest request, Model model)
    {
        String isbn = request.getParameter("isbn");
        if (!likedService.likedBookExists(isbn))
        {
            Book book = bookService.getBookByIsbn(isbn);

            if (book != null) { // add null check here
                LikedBooks likedBooks = new LikedBooks();
                likedBooks.setTitle(book.getTitle());
                likedBooks.setAuthor(book.getAuthor());
                likedBooks.setIsbn(book.getIsbn());
                likedBooks.setGenre(book.getGenre());
                likedBooks.setDescription(book.getDescription());
                likedBooks.setRating(book.getRating());
                likedBooks.setPrice(book.getPrice());
                likedBooks.setCoverImage(book.getCoverImage());

                System.out.println("Add Liked Books");
                likedService.addLikedBooks(likedBooks);
            } else {
                model.addAttribute("errorMessage", "Book not found"); // Set an error message in the model
            }
        } else {
            model.addAttribute("errorMessage", "Book already liked"); // Set an error message in the model
        }
        return "redirect:/liked";
    }
}