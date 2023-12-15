package com.example.ejercicio_link.entity;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Link {
    private String url;
    private Boolean valid = true;
    private String password;
    private int visits = 0;
}
