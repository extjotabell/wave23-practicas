package org.ejercicio.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private LocalDate releasDate;
    private LocalDate endate;
    private Integer genreId;
}
