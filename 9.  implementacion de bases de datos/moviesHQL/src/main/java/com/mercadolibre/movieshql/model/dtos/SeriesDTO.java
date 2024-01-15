package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SeriesDTO {

    private Long id;
    private String title;
    private Instant releaseDate;
    private Instant endDate;
    private GenresDTO genres;
}
