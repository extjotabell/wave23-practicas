package com.meli.bootcamp.oneToMany.model;

import jakarta.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = " cart_id", nullable = false)
    private Cart cart;
}
