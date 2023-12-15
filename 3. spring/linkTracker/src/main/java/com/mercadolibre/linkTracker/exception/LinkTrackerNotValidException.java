package com.mercadolibre.linkTracker.exception;

/**
 * Exception thrown when a Link Tracker entity is not valid.
 */
public class LinkTrackerNotValidException extends RuntimeException{

    public LinkTrackerNotValidException(String message){
        super(message);
    }
}
