package com.example.joyeria.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long nro_identificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean posee_piedra;
    Boolean poseeVenta;
}
