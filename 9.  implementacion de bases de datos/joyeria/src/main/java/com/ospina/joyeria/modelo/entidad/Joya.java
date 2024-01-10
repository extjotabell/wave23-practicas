package com.ospina.joyeria.modelo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "joya")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer nroIdentificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;
}
