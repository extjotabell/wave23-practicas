package com.meli.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String linkId;
    private String url;
    private String password;
    private long redirectCount;
    private boolean valid;

    public Link(String linkId, String url, String password) {
        this.linkId = linkId;
        this.url = url;
        this.password = password;
        this.redirectCount = 0;
        this.valid = true;
    }
}
