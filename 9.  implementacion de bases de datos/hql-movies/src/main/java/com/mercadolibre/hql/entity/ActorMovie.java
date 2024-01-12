package com.mercadolibre.hql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actor_movie", schema = "movies_db", catalog = "")
public class ActorMovie {

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
    /*@Basic
    @Column(name = "actor_id")
    private Integer actorId;
    @Basic
    @Column(name = "movie_id")
    private Integer movieId;*/
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private Actors actorsByActorId;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movies moviesByMovieId;
}
