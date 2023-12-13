package com.mercadolibre.linkTracker.exception;

public class LinkTrackerNotFoundException extends RuntimeException{
    public LinkTrackerNotFoundException(String message){
        super(message);
    }
}
