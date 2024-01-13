package com.jpa.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class EpisodeDTO {
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private BigDecimal rating;
    private SeasonDTO seasonEntity;
}
