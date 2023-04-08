package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.database.BookDatabase;
import com.spring.mvc.entity.Book;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDatabase bookDatabase;

    public void addBook(Book book) {
        bookDatabase.addBook(book);
    }
    public Book getBookById(Long id) {
        return bookDatabase.getBookById(id);
    }
    public List<Book> getAllBooks() {
        return bookDatabase.getAllBooks();
    }
    public void updateBook(Book book) {
        bookDatabase.updateBook(book);
    }
    public void deleteBook(Long id) {
        bookDatabase.deleteBook(id);
    }
    public Book findByTitleAndAuthor(String title,String author){
        return this.bookDatabase.findByTitleAndAuthor(title,author);
    }
}
