package com.spring.mvc.database;

import com.spring.mvc.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDatabase {
    @Autowired
    private SessionFactory sessionFactory;
    //@Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
    }

    public Book getBookById(Long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createQuery("from Book", Book.class).getResultList();

        session.close();
        return books;
    }

    public boolean updateBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();

        session.close();
        return true;
    }

    public void deleteBook(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        session.delete(book);
    }
    public Book findByTitleAndAuthor(String title, String author) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
        Root<Book> root = criteria.from(Book.class);
        criteria.select(root);
        criteria.where(builder.and(builder.equal(root.get("title"), title), builder.equal(root.get("author"), author)));
        Query query = session.createQuery(criteria);
        List<Book> results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }
}
