package com.youtube.practice.dto;

import java.util.Date;

public class BlogEntryDTO {
    private String blogTitle, authorName;
    private Date publishDate;

    public BlogEntryDTO() {
    }

    public BlogEntryDTO(String blogTitle, String authorName, Date publishDate) {
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
