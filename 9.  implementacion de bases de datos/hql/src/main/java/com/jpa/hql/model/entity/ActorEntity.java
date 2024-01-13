package com.jpa.hql.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "actors", schema = "movies_db")
public class ActorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @Basic
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Basic
    @Column(name = "rating", nullable = true, precision = 1)
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", nullable = true)
    private MovieEntity favoriteMovie;
    @ManyToMany
    @JoinTable(
            name="actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    private Set<EpisodeEntity> episodesEntities;
    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<MovieEntity> moviesEntities;
}
