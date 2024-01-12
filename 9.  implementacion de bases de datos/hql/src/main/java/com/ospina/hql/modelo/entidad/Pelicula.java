package com.ospina.hql.modelo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "movies")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "title", length = 500)
    private String title;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private Timestamp releaseDate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "genre_id")
    private Integer genreId;

    @ManyToMany(mappedBy = "peliculas")
    private List<Actor> actores;
}
