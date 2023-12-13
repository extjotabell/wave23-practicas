package com.example.LinkTracker.util;

import com.example.LinkTracker.exception.InvalidURLException;

import java.net.MalformedURLException;
import java.net.URL;

public class URLValidator {

    public boolean validateURL(String url){
        try {
            // Intentar crear una instancia de URL
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            throw new InvalidURLException("Invalid URL");
        }
    }

}
