package com.spring.mvc.controller;

import com.spring.mvc.entity.Book;
import com.spring.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class addBookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public String addBookPage() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBookPostPage(@RequestParam("title") String title,
                                  @RequestParam("author") String author,
                                  @RequestParam("isbn") String isbn,
                                  @RequestParam("genre") String genre,
                                  @RequestParam("description") String description,
                                  @RequestParam("rating") double rating,
                                  @RequestParam("price") double price,
                                  @RequestParam("coverImage") MultipartFile coverImage,
                                  RedirectAttributes redirectAttributes) {
        // validate the form fields
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || genre.isEmpty() || description.isEmpty() || coverImage.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please fill in all required fields.");
            return "redirect:/addBook";
        }

        // save cover image to disk
        String coverImageFileName = coverImage.getOriginalFilename();
        String savePath = "path/to/save/cover/images/" + coverImageFileName;
        try {
            coverImage.transferTo(new File(savePath));
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while uploading the cover image. Please try again later.");
            return "redirect:/addBook";
        }

        // create new book object and set its properties
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setGenre(genre);
        book.setDescription(description);
        book.setCoverImage(savePath);
        book.setRating(rating);
        book.setPrice(price);

        // save new book to database and redirect to dashboard
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("success", "Book added successfully.");
        return "redirect:/dashboard";
    }
}
