package com.spring.mvc.database;

import com.spring.mvc.entity.ReadLaterBooks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReadLaterDatabase {
    @Autowired
    private SessionFactory factory;

    public void addReadLaterBooks(ReadLaterBooks readLater) {
        if (!bookExists(readLater.getTitle(), readLater.getAuthor())) {
            Session session = factory.getCurrentSession();
            session.save(readLater);
        }
    }
    public boolean bookExists(String title, String author) {
        Session session = factory.getCurrentSession();
        String sql = "FROM ReadLaterBooks WHERE title = :title AND author = :author";
        ReadLaterBooks readLater = session.createQuery(sql, ReadLaterBooks.class)
                .setParameter("title", title)
                .setParameter("author", author)
                .uniqueResult();
        return readLater != null;
    }
    public List<ReadLaterBooks> getReadLaterBooks() {
        Session session = factory.getCurrentSession();
        String sql = "SELECT new com.spring.mvc.entity.ReadLaterBooks(r.id, r.title, r.author, r.isbn, r.genre, r.description, r.rating, r.price, r.coverImage) FROM ReadLaterBooks r";
        List<ReadLaterBooks> readLaterBooks = session.createQuery(sql, ReadLaterBooks.class)
                .getResultList();
        return readLaterBooks;
    }

    public void removeBook(long bookId) {
        Session session = factory.getCurrentSession();
        ReadLaterBooks readLater = session.get(ReadLaterBooks.class, bookId);
        if (readLater != null) {
            session.delete(readLater);
        }
    }
}
