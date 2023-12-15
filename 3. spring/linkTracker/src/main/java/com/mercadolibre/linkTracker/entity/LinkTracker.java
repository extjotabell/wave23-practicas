package com.mercadolibre.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity representing a Link Tracker link.
 */
@Data
@AllArgsConstructor
public class LinkTracker {
    /**
     * The unique identifier for the Link Tracker link.
     */
    private Long id;
    /**
     * The URL associated with the Link Tracker link.
     */
    private String url;
    /**
     * Optional password for securing the Link Tracker link. Can be null if no password is set.
     */
    private String password;
    /**
     * The count of how many times the Link Tracker link has been redirected.
     */
    private int redirectCount;

    /**
     * Constructs a LinkTracker object with the specified ID, URL, and password.
     *
     * @param id       The unique identifier for the Link Tracker link.
     * @param url      The URL associated with the Link Tracker link.
     * @param password Optional password for securing the Link Tracker link. Can be null if no password is set.
     */
    public LinkTracker(Long id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.redirectCount = 0;
    }

    /**
     * Increments the redirect count each time the Link Tracker link is redirected.
     */
    public void incrementRedirectCount() {
        this.redirectCount++;
    }
}
