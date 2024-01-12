package com.example.hql_vehiculos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "siniestro")
@Getter
@Setter
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_siniestro")
    private Date fecha;

    @Column(name = "perdida_economica")
    private Float perdida;
}
