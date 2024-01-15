package com.example.ejercicioHQL.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actors")
@Getter
@Setter
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "favorite_movie_id")
    Movie favoriteMovie;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    Set<ActorMovie> movies;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    Set<ActorEpisode> episodes;

}
