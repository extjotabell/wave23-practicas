package com.meli.Vehiculos.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.Vehiculos.model.Vehiculo;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehiculoRequestDTO implements Serializable {

    String patente;

    String marca;

    String modelo;

    @JsonProperty("year_fabricacion")
    Integer yearFabricacion;

    @JsonProperty("cantidad_ruedas")
    Integer cantidadRuedas;

    public VehiculoRequestDTO(String patente, String marca, String modelo, Integer yearFabricacion, Integer cantidadRuedas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.yearFabricacion = yearFabricacion;
        this.cantidadRuedas = cantidadRuedas;
    }
}