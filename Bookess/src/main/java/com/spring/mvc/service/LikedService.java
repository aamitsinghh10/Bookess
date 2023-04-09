package com.spring.mvc.service;

import com.spring.mvc.database.LikedDatabase;
import com.spring.mvc.entity.LikedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedService {
    @Autowired
    private LikedDatabase likedDatabase;

    public void addLikedBooks(LikedBooks likedBooks) {
        this.likedDatabase.addLikedBooks(likedBooks);
    }

    public boolean likedBookExists(String title, String author) {
        return likedDatabase.likedBookExists(title, author);
    }

    public List<LikedBooks> getLikedBooks() {
        return likedDatabase.getLikedBooks();
    }

    public void removeLikedBook(long bookId) {
        likedDatabase.removeLikedBook(bookId);
    }
}