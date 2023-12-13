package com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for blog entry-related exceptions.
 */
@ControllerAdvice
public class ExceptionConfig {
    /**
     * Handles EntryBlogAlreadyExistsException by returning a ResponseEntity with HTTP status CONFLICT (409)
     * and the exception message.
     *
     * @param entryBlogException the exception to handle.
     * @return a ResponseEntity with CONFLICT status and the exception message.
     */
    @ExceptionHandler(EntryBlogAlreadyExistsException.class)
    public ResponseEntity<?> entryBlogException(EntryBlogAlreadyExistsException entryBlogException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(entryBlogException.getMessage());
    }

    /**
     * Handles EntryBlogNotExistsException by returning a ResponseEntity with HTTP status NOT_FOUND (404)
     * and the exception message.
     *
     * @param entryBlogNotExistsException the exception to handle.
     * @return a ResponseEntity with NOT_FOUND status and the exception message.
     */
    @ExceptionHandler(EntryBlogNotExistsException.class)
    public ResponseEntity<?> entryBlogNotExistsException(EntryBlogNotExistsException entryBlogNotExistsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entryBlogNotExistsException.getMessage());
    }
}
