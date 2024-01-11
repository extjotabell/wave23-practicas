package org.ejercicio.pruebarelaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    // Acá tambien definimos el OneToOne para generar la bidireccionalidad de las clases
    // mappedBy = hace referencia al nombre del atributo que está del otro lado de one. En este caso en User
    @OneToOne(mappedBy = "address")
    private User user;
}
