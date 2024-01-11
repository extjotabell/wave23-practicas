package com.meli.bootcamp.oneToMany.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "cart")
    private Set<Item> itemSet;


}
