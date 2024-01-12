package com.meli.movies.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", initialValue = 50, allocationSize = 1)
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    public Set<Movie> movies = new HashSet<>();
}
