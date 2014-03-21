// ============================================================================
//  File          : HibernateBookDao
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.db.hibernate;

import com.xpinjection.tdd.db.BookDao;
import com.xpinjection.tdd.domain.Book;
import org.hibernate.SessionFactory;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class HibernateBookDao implements BookDao {
    private final SessionFactory sessionFactory;

    public HibernateBookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book addBook(Book book) {
        sessionFactory.getCurrentSession().persist(book);
        return book;
    }

    @Override
    public void removeBook(Book book) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from Book where id = :id")
                .setLong("id", book.getId()).executeUpdate();
    }
}
