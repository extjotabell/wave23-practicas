package com.mercadolibre.hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actors {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Basic
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "rating")
    private Double rating;
    /*@Basic
    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;*/
    @OneToMany(mappedBy = "actorsByActorId")
    private List<ActorEpisode> actorEpisodesById;
    @OneToMany(mappedBy = "actorsByActorId")
    private List<ActorMovie> actorMoviesById;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movies moviesByFavoriteMovieId;
}
