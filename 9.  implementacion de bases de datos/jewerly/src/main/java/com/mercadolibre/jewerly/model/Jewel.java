package com.mercadolibre.jewerly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jewel")
public class Jewel {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String material;
    private Double weight;
    @Column(length = 45)
    private String particularity;
    @Column(name = "have_stone", nullable = false)
    private Boolean haveStone;
    @Column(name = "sell_or_no", nullable = false)
    private Boolean sellOrNo;
}
