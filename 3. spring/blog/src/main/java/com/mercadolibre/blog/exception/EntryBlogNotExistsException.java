package com.mercadolibre.blog.exception;

/**
 * Exception thrown when attempting to retrieve a blog entry that does not exist.
 */
public class EntryBlogNotExistsException extends RuntimeException{

    public EntryBlogNotExistsException(String message){
        super(message);
    }
}
