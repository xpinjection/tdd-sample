// ============================================================================
//  File          : BookController
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.web;

import com.xpinjection.tdd.db.BookDao;
import com.xpinjection.tdd.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class BookController {
    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String jobRequestProcessed(@RequestParam("title") String title, @RequestParam("tags") String tags) {
        Book book = new Book(title);
        book.setTagsList(tags);
        Book added = bookDao.addBook(book);
        return added.getId().toString();
    }
}
