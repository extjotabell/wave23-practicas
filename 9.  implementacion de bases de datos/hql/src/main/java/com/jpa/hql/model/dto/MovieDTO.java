package com.jpa.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MovieDTO {
    private Integer id;
    private String title;
    private BigDecimal rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private GenreDTO genre;
}
