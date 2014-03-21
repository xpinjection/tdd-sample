// ============================================================================
//  File          : BookTest
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.domain;

import com.google.common.collect.Sets;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.unitils.util.CollectionUtils.asSet;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class BookTest {
    private Book book = new Book();

    @Test
    public void ifNoTagsInListCreateEmptyTagsSet() {
        book.setTagsList(" \t \n ");
        assertTrue(book.getTags().isEmpty());
    }

    @Test
    public void tagsListIsSplitBySeparatorAndTagsTrimmed() {
        book.setTagsList(" cool \t| new");
        assertEquals(asSet("cool", "new"), book.getTags());
    }

    @Test
    public void emptyTagsSetIsTransformedToEmptyStringAsTagsList() {
        assertEquals("", book.getTagsList());
    }

    @Test
    public void tagsAreJoinedInListWithSeparatorAndTrimmed() {
        book.setTags(Sets.newLinkedHashSet(asList("\t cool", "new ")));
        assertEquals("cool|new", book.getTagsList());
    }
}
