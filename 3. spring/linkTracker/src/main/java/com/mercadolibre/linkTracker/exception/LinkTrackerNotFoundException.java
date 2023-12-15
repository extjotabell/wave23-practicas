package com.mercadolibre.linkTracker.exception;

/**
 * Exception thrown when a Link Tracker entity is not found.
 */
public class LinkTrackerNotFoundException extends RuntimeException{
    public LinkTrackerNotFoundException(String message){
        super(message);
    }
}
