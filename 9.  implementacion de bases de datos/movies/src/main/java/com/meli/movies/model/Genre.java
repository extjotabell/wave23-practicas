package com.meli.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "genres")
@Getter @Setter
public class Genre extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    private Integer ranking;

    private short active;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Movie> movies;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Serie> series;
}
