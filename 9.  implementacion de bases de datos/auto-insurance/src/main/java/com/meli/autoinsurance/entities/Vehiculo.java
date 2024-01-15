package com.meli.autoinsurance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="vehiculos")
public class Vehiculo {
    @Id
    @Column(name="id_vehiculo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name="anio_de_fabricacion")
    private Integer anioDeFabricacion;
    @Column(name="cantidad_de_ruedas")
    private Integer cantidadDeRuedas;
}