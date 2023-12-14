package com.ejLinkTracker.ejLinkTracker.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTracker {
    private Long id;
    private String url;
    private String password;
    private int redirectCount;

    public void increaseRedirectCount(){
        redirectCount++;
    }

}
