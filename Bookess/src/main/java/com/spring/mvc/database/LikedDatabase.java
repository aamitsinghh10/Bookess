package com.spring.mvc.database;

import com.spring.mvc.entity.LikedBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class LikedDatabase {
    @Autowired
    private SessionFactory factory;
    public void addLikedBooks(LikedBooks likedBooks) {
        if (!likedBookExists(likedBooks.getTitle(), likedBooks.getAuthor())) {
            Session session = factory.getCurrentSession();
            session.save(likedBooks);
        }
    }

    public boolean likedBookExists(String title, String author) {
        Session session = factory.getCurrentSession();
        String sql = "FROM LikedBooks WHERE title = :title AND author = :author";
        LikedBooks likedBooks = session.createQuery(sql, LikedBooks.class)
                .setParameter("title", title)
                .setParameter("author", author)
                .uniqueResult();
        return likedBooks != null;
    }
    public List<LikedBooks> getLikedBooks() {
        Session session = factory.getCurrentSession();
        String sql = "SELECT new com.spring.mvc.entity.LikedBooks(r.id, r.title, r.author, r.isbn, r.genre, r.description, r.rating, r.price, r.coverImage) FROM LikedBooks r";
        List<LikedBooks> likedBooks = session.createQuery(sql, LikedBooks.class)
                .getResultList();
        return likedBooks;
    }

    public void removeLikedBook(long bookId) {
        Session session = factory.getCurrentSession();
        LikedBooks likedBooks = session.get(LikedBooks.class, bookId);
        if (likedBooks != null) {
            session.delete(likedBooks);
        }
    }
}

