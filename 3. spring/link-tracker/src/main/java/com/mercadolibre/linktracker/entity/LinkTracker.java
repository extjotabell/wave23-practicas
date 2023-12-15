package com.mercadolibre.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkTracker {
    int linkId;
    int redirections = 0;
    String url;
    boolean enable = true;
    String password = null;

    public void incrementRedirection(){
        this.redirections++;
    }
}
