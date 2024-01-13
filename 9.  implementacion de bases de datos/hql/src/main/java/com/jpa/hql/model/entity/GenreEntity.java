package com.jpa.hql.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "genres", schema = "movies_db")
public class GenreEntity {
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
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "ranking", nullable = false)
    private Integer ranking;
    @Basic
    @Column(name = "active", nullable = false)
    private Byte active;
    @OneToMany(mappedBy = "genre")
    private Set<MovieEntity> movieEntities;
    @OneToMany(mappedBy = "genre")
    private Set<SerieEntity> serieEntities;
}
