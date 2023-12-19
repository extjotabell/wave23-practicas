package com.ejercicio.LinkTracker.helpers;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlValidator {
    public static boolean isValidURL(String url) {
        try {
            URI uri = new URI(url);
            return uri.getScheme() != null;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
