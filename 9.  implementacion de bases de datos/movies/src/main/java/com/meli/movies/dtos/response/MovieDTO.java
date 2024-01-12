package com.meli.movies.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private GenreDTO genre;
}