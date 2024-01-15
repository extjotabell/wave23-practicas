package com.example.miniserie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerieDTO {
    private Long id;
    private String name;
    private double rating;
    private int amount_of_awards;
}
