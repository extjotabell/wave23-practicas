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
@Table(name = "actors")
public class Actor {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;
    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;
}
