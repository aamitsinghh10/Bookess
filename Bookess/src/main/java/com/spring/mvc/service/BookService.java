package com.spring.mvc.service;

import com.spring.mvc.database.BookDatabase;
import com.spring.mvc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDatabase bookDatabase;

    public void addBook(Book book) {
        bookDatabase.addBook(book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookDatabase.getBookByIsbn(isbn);
    }
    public Book getBookById(long bookId){
        return this.bookDatabase.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookDatabase.getAllBooks();
    }

    public boolean updateBook(Book book) {
        return bookDatabase.updateBook(book);
    }

    public void deleteBook(Long id) {
        bookDatabase.deleteBook(id);
    }

    public Book findByIsbn(String isbn) {
        return this.bookDatabase.findByIsbn(isbn);
    }
}
