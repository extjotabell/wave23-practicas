package com.example.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Link {

    private static int linkCount = 0;

    private int id;
    private String url;
    private String password;
    private int counter;
    private boolean isValid;

    public Link(){
        this.id = ++linkCount;
    }

    public Link(String url, String password){
        this();
        this.url = url;
        this.counter = 0;
        this.isValid = true;
        this.password = password;
    }

    public void incrementCounter(){
        this.counter++;
    }

}
