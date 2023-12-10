package com.covid19.covid19.entify;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private Integer codigo;
    private String nombre;
    private String nivelGravedad;

}
