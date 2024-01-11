package com.example.ejemploRelaciones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    private Long id;
    private String calle;
    private Integer numeroExterior;
    private Integer numeroInterior;
    private String delegacion;
    private String ciudad;
    private String estado;

    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;
}
