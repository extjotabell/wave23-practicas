package com.mercadolibre.movieshql.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GenresDTO {

    private Long id;
    private String name;
    private Long ranking;
    private Boolean active;
}
