package com.meli.jewelry.entities;


import com.meli.jewelry.enums.MATERIAL;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jewel {
    @Id
    @Column(name= "identity_number")
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