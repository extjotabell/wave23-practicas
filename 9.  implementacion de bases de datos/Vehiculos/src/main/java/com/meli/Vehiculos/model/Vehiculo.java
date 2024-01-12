package com.meli.Vehiculos.model;

import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "patente", nullable = false)
    String patente;

    @Column(name = "marca", nullable = false)
    String marca;

    @Column(name = "modelo", nullable = false)
    String modelo;

    @Column(name = "year_fabricacion", nullable = false)
    Integer yearFabricacion;

    @Column(name = "cantidad_ruedas", nullable = false)
    Integer cantidadRuedas;

    public Vehiculo(VehiculoRequestDTO vehiculoDTO) {
        this.patente = vehiculoDTO.getPatente();
        this.marca = vehiculoDTO.getMarca();
        this.modelo = vehiculoDTO.getModelo();
        this.yearFabricacion = vehiculoDTO.getYearFabricacion();
        this.cantidadRuedas = vehiculoDTO.getCantidadRuedas();
    }

}
