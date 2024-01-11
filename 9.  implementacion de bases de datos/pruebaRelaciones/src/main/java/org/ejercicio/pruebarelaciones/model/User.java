package org.ejercicio.pruebarelaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    // cascade es logica de eliminacion de datos
    @OneToOne(cascade = CascadeType.ALL)
    // En 1on1 hay que definir de que lado tiene más sentido tener la PK
    // name = nombre que quedará en la tabla users
    // referenceColumnName = en este caso hace referencia al id de Address.class
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
