package spring.apiclothing.dto;

import lombok.Data;

@Data
public class ClothingDto {
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precio_venta;
}
