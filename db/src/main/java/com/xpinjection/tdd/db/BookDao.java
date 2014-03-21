// ============================================================================
//  File          : BookDao
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.db;

import com.xpinjection.tdd.domain.Book;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public interface BookDao {
    Book addBook(Book book);

    void removeBook(Book book);
}
