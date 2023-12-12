package com.covid19.covid19.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class SintomaDTO {
    private String nombre;
    private String nivelGravedad;
}
