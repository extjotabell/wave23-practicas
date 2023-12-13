package com.example.linktracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private String url;
    private int llamadas;
    private String password;
    private boolean activo;
    public void incrementarLlamados(){
        llamadas++;
    }

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
        llamadas=0;
        activo=true;
    }
}
