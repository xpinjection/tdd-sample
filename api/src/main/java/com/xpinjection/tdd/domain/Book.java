// ============================================================================
//  File          : Book
//  Created       : 03.07.2013   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class Book {
    private static final char TAG_SEPARATOR = '|';

    private Long id;
    private String title;
    private Set<String> tags = Collections.emptySet();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public void setTagsList(String tagsList) {
        String[] tagsFromList = StringUtils.split(tagsList, TAG_SEPARATOR);
        if (tagsFromList.length > 0) {
            tags = new HashSet<String>();
            fillTags(tagsFromList);
        }
    }

    private void fillTags(String[] tagsFromList) {
        for (String tag : tagsFromList) {
            if (StringUtils.isNotBlank(tag)) {
                tags.add(StringUtils.trim(tag));
            }
        }
    }

    public String getTagsList() {
        Set<String> trimmedTags = new LinkedHashSet<String>();
        for (String tag : tags) {
            trimmedTags.add(StringUtils.trim(tag));
        }
        return StringUtils.join(trimmedTags, TAG_SEPARATOR);
    }
}
