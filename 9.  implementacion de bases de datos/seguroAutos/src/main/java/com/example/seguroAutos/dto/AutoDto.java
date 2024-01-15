package com.example.seguroAutos.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutoDto implements Serializable {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private String anioFabricacion;
    private int numRuedas;
}
