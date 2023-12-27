package com.example.blog.exception;

public class EntryBlogNotFoundException extends RuntimeException{
    public EntryBlogNotFoundException(Long id) {
        super("Doesn't exists an EntryBlod with id = " + id);
    }
}
