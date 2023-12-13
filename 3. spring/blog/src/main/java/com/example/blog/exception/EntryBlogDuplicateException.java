package com.example.blog.exception;

public class EntryBlogDuplicateException extends RuntimeException {
    public EntryBlogDuplicateException(Long id) {
        super("An EntryBlog with the ID = " + id + " already exists");
    }
}
