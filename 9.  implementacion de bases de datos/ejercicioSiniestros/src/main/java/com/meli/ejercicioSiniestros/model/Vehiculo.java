package com.meli.ejercicioSiniestros.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("ano_fabricacion")
    private Integer anoFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculoDenunciado")
    private Set<Siniestro> siniestros;
}
