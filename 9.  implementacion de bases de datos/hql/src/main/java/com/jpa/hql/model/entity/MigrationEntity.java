package com.jpa.hql.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "migrations", schema = "movies_db")
public class MigrationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "migration", nullable = false, length = 255)
    private String migration;
    @Basic
    @Column(name = "batch", nullable = false)
    private Integer batch;
}
