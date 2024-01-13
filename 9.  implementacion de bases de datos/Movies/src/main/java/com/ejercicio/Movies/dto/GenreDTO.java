package com.ejercicio.Movies.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String name;
    private int ranking;
    private boolean active;
}
