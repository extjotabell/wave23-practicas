package com.jpa.relaciones.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;
}
