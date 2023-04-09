package com.spring.mvc.service;

import com.spring.mvc.database.ReadLaterDatabase;
import com.spring.mvc.entity.ReadLaterBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadLaterService {
    @Autowired
    private ReadLaterDatabase readLaterDatabase;
    public void addReadLaterBooks(ReadLaterBooks readLater){
        this.readLaterDatabase.addReadLaterBooks(readLater);
    }
    public void removeBook(long bookId) {
        readLaterDatabase.removeBook(bookId);
    }
    public boolean bookExists(String title, String author) {
        return readLaterDatabase.bookExists(title, author);
    }
    public List<ReadLaterBooks> getReadLaterBooks() {
        return readLaterDatabase.getReadLaterBooks();
    }
}



