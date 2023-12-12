package com.meli.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ServicesDTO {
    private String date;
    private double kilometers;
    private String descriptions;
}
