package com.meli.Vehiculos.model;

import com.meli.Vehiculos.dto.request.SiniestroRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    LocalDate fecha;

    @Column(name = "perdida_economica")
    Double perdidaEconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    Vehiculo vehiculo;

    public Siniestro(SiniestroRequestDTO siniestroDTO, Vehiculo vehiculo) {
        this.fecha = siniestroDTO.getFecha();
        this.perdidaEconomica = siniestroDTO.getPerdidaEconomica();
        this.vehiculo = vehiculo;
    }
}
