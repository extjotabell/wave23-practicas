package org.ejercicio.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Integer seasonId;
}
