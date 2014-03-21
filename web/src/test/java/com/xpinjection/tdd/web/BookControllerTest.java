// ============================================================================
//  File          : BookControllerTest
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.annotation.RegularMock;

import java.util.Set;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.unitils.easymock.EasyMockUnitils.refEq;
import static org.unitils.util.CollectionUtils.asSet;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
public class BookControllerTest {
    @RegularMock
    private BookDao bookDao;

    private MockMvc mvc;

    private String title = "Spring MVC in Action";

    @Before
    public void setUp() throws Exception {
        mvc = standaloneSetup(new BookController(bookDao))
                .setUseSuffixPatternMatch(false).setUseTrailingSlashPatternMatch(false).build();
    }

    @Test
    public void bookIsSuccessfullyAdded() throws Exception {
        Book book = createBook(null, asSet("spring", "mvc"));
        Book added = createBook(15L, asSet("spring", "mvc"));
        expect(bookDao.addBook(refEq(book))).andReturn(added);
        replay(bookDao);

        mvc.perform(post("/books/add").param("title", title).param("tags", "spring|mvc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("15"));
    }

    private Book createBook(Long id, Set<String> tags) {
        Book book = new Book(title);
        book.setTags(tags);
        book.setId(id);
        return book;
    }

}
