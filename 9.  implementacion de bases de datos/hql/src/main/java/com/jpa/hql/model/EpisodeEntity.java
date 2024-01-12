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
@Table(name = "episodes", schema = "movies_db")
public class EpisodeEntity {
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
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
    @Basic
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Basic
    @Column(name = "rating", nullable = false, precision = 1)
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name = "season_id", nullable = true)
    private SeasonEntity seasonEntity;
    @ManyToMany(mappedBy = "episodesEntities")
    private Set<ActorEntity> actorsEntities;
}
