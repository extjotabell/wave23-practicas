package com.ejercicio.Movies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private Double rating;
    private int awards;
    @JsonProperty("release_date")
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonProperty("genre_id")
    private Genre genre;

    @ManyToMany(mappedBy = "movies")
    @JsonIgnore
    private List<Actor> actors;
}