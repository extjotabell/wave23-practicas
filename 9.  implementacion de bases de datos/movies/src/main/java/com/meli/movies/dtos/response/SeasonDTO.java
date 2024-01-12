package com.meli.movies.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private SerieDTO serie;
}
