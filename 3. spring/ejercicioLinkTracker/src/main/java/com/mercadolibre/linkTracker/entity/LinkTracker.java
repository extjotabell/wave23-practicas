package com.mercadolibre.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkTracker {
    private Long id;
    private String url;
    private String password;
    private int redirectCount;

    public void increaseRedirectCount(){
        redirectCount++;
    }
}
