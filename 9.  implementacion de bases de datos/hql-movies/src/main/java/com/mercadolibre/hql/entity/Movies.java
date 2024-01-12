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
public class Movies {

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
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "rating")
    private Double rating;
    @Basic
    @Column(name = "awards")
    private Integer awards;
    @Basic
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Basic
    @Column(name = "length")
    private Double length;
    /*@Basic
    @Column(name = "genre_id")
    private Integer genreId;*/
    @OneToMany(mappedBy = "moviesByMovieId")
    private List<ActorMovie> actorMoviesById;
    @OneToMany(mappedBy = "moviesByFavoriteMovieId")
    private List<Actors> actorsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genres genresByGenreId;
}
