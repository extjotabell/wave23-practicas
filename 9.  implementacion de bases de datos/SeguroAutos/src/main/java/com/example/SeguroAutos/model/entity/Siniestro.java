package com.example.SeguroAutos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "siniestro")
@Getter
@Setter
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechaSiniestro")
    private Date fecha;

    private Float perdida;

}
