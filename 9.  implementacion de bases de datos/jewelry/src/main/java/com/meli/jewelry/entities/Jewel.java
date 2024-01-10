package com.meli.jewelry.entities;


import com.meli.jewelry.enums.MATERIAL;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jewel {
    @Id
    @Column(name= "identity_number")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identityNumber;
    private String name;
    private MATERIAL material;
    private Double weight;
    private String particularity;
    @Column(name = "has_stone")
    private Boolean hasStone;
    //for sale or not
    private Boolean available;

}