package com.example.Hql.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "actors")
@Getter @Setter
public class Actor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "rating", precision = 1)
    private Double rating;

    @Column(name = "favorite_movie_id")
    private Long favoriteMovieId;

    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;
}
