package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EpisodesDTO {

    private Long id;
    private String title;
    private Long number;
    private Instant releaseDate;
    private BigDecimal rating;
    private SeasonsDTO seasons;
}
