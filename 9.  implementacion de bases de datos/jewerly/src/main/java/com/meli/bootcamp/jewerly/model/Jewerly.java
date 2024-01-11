package com.meli.bootcamp.jewerly.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jewerlies")
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean posee_piedra;
    @Column(columnDefinition = "BOOLEAN")
    private Boolean venta_o_no;
}
