package com.mercadolibre.blog.exception;


public class EntryBlogNotExistsException extends RuntimeException {

    public EntryBlogNotExistsException(String message) {
        super(message);
    }
}
