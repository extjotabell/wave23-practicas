package com.ospina.seguros.modelo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String patente;
    String marca;
    String modelo;
    @Column(name = "anio_fabricacion")
    Integer anioFabricacion;
    @Column(name = "cantidad_ruedas")
    Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado")
    List<Siniestro> siniestros;

}
