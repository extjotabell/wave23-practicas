package com.mercadolibre.blog.exception;

/**
 * Exception thrown when attempting to create a blog entry with an ID that already exists.
 */
public class EntryBlogAlreadyExistsException extends RuntimeException{
    public EntryBlogAlreadyExistsException(String message){
        super(message);
    }
}
