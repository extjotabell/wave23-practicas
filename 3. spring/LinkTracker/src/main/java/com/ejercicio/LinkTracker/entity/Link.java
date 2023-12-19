package com.ejercicio.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class Link {
    private int id;
    private String link;
    private Boolean active;
    private String password;
    private int statistics = 0;
}
