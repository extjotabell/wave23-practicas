package com.example.blog.exception;

public class EntryBlogListEmptyException extends RuntimeException{
    public EntryBlogListEmptyException() {
        super("Doesn't exists entries blogs");
    }
}
