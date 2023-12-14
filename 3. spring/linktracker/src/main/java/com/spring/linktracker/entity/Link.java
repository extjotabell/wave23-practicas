package com.spring.linktracker.entity;

import lombok.*;

@Setter
@Getter
@ToString

public class Link {
    private int linkId;
    private static int id = 0;
    private String url, password;
    private int countRedirect;
    private boolean valid;

    public Link(String url, String password) {
        this.linkId = ++id;
        this.url = url;
        this.password = password;
        this.valid = true;
    }

    public void incrementCountRedirect() {
        countRedirect++;
    }
}
