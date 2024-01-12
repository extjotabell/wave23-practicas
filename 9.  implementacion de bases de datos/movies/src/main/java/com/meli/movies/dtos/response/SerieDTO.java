package com.meli.movies.dtos.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.meli.movies.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Genre genre;
    @JsonAlias("number_seasons")
    private Integer numberSeasons;
}
