package org.ejercicio.pruebarelaciones.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private LocalDate fecha;

    @Id
    private Long clientId;

    /*
        USE prueba_jpa;

        INSERT INTO compra
        VALUES
        (1, "2023-10-10"),
        (2, "2023-10-11"),
        (1, "2023-10-12"),
        (1, "2023-10-13"),
        (1, "2023-10-14")

        Al querer insertar estos datos, la primera vez es correcto. Al querer volver a insertarlos ya no me deja realizar la misma combinacion de claves.

    *  */
}
