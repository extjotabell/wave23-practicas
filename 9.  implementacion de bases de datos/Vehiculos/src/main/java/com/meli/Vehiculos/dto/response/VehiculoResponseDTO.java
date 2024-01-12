package com.meli.Vehiculos.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.Vehiculos.model.Vehiculo;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoResponseDTO implements Serializable {

    Long id;

    String patente;

    String marca;

    String modelo;

    @JsonProperty("year_fabricacion")
    Integer yearFabricacion;

    @JsonProperty("cantidad_ruedas")
    Integer cantidadRuedas;

    @JsonProperty("perdidas_totales")
    Double perdidasTotales;

    public VehiculoResponseDTO(Vehiculo vehiculo) {
        this.id = vehiculo.getId();
        this.patente = vehiculo.getPatente();
        this.marca = vehiculo.getMarca();
        this.modelo = vehiculo.getModelo();
        this.yearFabricacion = vehiculo.getYearFabricacion();
        this.cantidadRuedas = vehiculo.getCantidadRuedas();
    }

    public VehiculoResponseDTO(String patente, String marca, String modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    public VehiculoResponseDTO(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    public VehiculoResponseDTO(String patente, String marca, String modelo, Double perdidasTotales) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.perdidasTotales = perdidasTotales;
    }
}