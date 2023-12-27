package com.mercadolibre.blog.exception;


public class EntryBlogAlreadyExistsException extends RuntimeException {
    public EntryBlogAlreadyExistsException(String message) {
        super(message);
    }
}
