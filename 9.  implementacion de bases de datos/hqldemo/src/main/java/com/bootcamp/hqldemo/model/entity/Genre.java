package com.bootcamp.hqldemo.model.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter @Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "active")
    private Boolean active;

}
