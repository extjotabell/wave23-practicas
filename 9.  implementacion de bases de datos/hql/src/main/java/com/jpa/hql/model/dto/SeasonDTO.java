package com.jpa.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SeasonDTO {
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private SerieDTO serie;
}
