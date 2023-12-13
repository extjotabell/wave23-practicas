package com.example.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {
    private String url;
    private int llamadas;
    private boolean activo;

}
