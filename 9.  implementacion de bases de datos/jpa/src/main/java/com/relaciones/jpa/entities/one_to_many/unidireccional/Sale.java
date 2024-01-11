package com.relaciones.jpa.entities.one_to_many.unidireccional;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private List<SaleDetails> list;
}
