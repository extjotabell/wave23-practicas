package com.jpa.hql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "movies", schema = "movies_db")
public class MovieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @Basic
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Basic
    @Column(name = "rating", nullable = false, precision = 1)
    private BigDecimal rating;
    @Basic
    @Column(name = "awards", nullable = false)
    private Integer awards;
    @Basic
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Basic
    @Column(name = "length", nullable = true)
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true)
    private GenreEntity genre;
    @ManyToMany(mappedBy = "moviesEntities")
    private Set<ActorEntity> castActorsEntities;
    @OneToMany(mappedBy = "favoriteMovie")
    private Set<ActorEntity> likedByActorsEntities;
}
