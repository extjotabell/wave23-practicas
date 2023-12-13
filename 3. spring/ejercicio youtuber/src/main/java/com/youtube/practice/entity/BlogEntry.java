package com.youtube.practice.entity;

import java.util.Date;

public class BlogEntry {
    private static int countId = 0;
    private int idBlog;
    private String blogTitle, authorName;
    private Date publishDate;

    public BlogEntry() {
        this.idBlog = ++countId;
    }

    public BlogEntry(String blogTitle, String authorName, Date publishDate) {
        this();
        this.blogTitle = blogTitle;
        this.authorName = authorName;
        this.publishDate = publishDate;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
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
