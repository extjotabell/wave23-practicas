package com.ejercicio.Movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private Double rating;
    private int awards;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    private Integer length;
    @JsonProperty("genre_id")
    private GenreDTO genre;
}
