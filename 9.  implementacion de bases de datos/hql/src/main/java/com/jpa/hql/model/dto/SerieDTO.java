package com.jpa.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SerieDTO {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private GenreDTO genre;
}
