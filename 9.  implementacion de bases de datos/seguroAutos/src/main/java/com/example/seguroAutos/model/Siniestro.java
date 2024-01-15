package com.example.seguroAutos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestros", schema = "autos_db")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_siniestro",columnDefinition = "DATE")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_Economica")
    private double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;


}
