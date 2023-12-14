package com.ejLinkTracker.ejLinkTracker.exception;

public class LinkTrackerNotFoundException extends RuntimeException{
    public LinkTrackerNotFoundException(String message){
        super(message);
    }
}