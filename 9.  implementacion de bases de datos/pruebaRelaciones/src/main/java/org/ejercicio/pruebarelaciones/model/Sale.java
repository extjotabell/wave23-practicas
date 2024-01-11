package org.ejercicio.pruebarelaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // En esta logica de OneToMany Unidireccional para acceder a saleDatails hay que pasar primero por Sale
    @OneToMany(cascade = CascadeType.ALL)
    // Como se va a llamar el del lado de la N
    @JoinColumn(name = "sale_id")
    private List<SaleDetails> list;
}
