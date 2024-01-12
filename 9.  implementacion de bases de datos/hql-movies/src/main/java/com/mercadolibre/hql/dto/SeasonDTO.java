package com.mercadolibre.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDTO {
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
}
