// ============================================================================
//  File          : HibernateBookDaoTest
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.db.hibernate;

import com.xpinjection.tdd.db.AbstractDbTest;
import com.xpinjection.tdd.db.BookDao;
import com.xpinjection.tdd.domain.Book;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import javax.persistence.PersistenceException;
import java.util.LinkedHashSet;

import static java.util.Arrays.asList;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class HibernateBookDaoTest extends AbstractDbTest {
    @SpringBean("bookDao")
    private BookDao dao;

    @Test
    @ExpectedDataSet
    public void bookIsAdded() throws PersistenceException {
        Book book = new Book("Hibernate in Action");
        book.setTags(new LinkedHashSet<String>(asList("blog", "java")));

        assertNotNull(dao.addBook(book).getId());
    }

    @Test
    @DataSet
    public void bookIsRemoved() throws PersistenceException {
        Book book = new Book("Spring in Action");
        book.setId(1L);
        dao.removeBook(book);

        assertEquals(0, getNumberOfRecords("book"));
    }
}
