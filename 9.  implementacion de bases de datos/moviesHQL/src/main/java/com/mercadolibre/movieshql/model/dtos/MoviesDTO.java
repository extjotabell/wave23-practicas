package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MoviesDTO implements Serializable{

    private Long id;
    private String title;
    private BigDecimal rating;
    private Long awards;
    private Instant releaseDate;
    private Long length;
    private GenresDTO genres;
}
