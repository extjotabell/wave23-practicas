package com.example.lasPerlas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewJoyaRequestDto {

    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;

}
