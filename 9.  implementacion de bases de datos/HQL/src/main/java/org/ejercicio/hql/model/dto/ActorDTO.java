package org.ejercicio.hql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ejercicio.hql.model.entity.Movie;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
}
