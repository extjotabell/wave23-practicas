package com.meli.jewelry.dtos;

import com.meli.jewelry.enums.MATERIAL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JewelDTO {
    private Long identityNumber;
    private String name;
    private MATERIAL material;
    private Double weight;
    private String particularity;
    private Boolean hasStone;
    //for sale or not
    private Boolean available;
}
