package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ActorsDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private MoviesDTO favoriteMovie;

}
