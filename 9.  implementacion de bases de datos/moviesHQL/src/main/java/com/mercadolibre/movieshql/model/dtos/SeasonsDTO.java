package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SeasonsDTO {

    private Long id;
    private String title;
    private Long number;
    private Instant releaseDate;
    private Instant endDate;
    private SeriesDTO series;
}
