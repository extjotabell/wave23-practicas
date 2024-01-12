package org.ejercicio.hql.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private Integer genreId;
    @OneToMany(mappedBy = "movie")
    private List<ActorMovie> actorMovies;
}
