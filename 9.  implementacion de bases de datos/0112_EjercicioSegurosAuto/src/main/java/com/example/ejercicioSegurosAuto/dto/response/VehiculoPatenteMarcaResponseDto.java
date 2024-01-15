package com.example.ejercicioSegurosAuto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoPatenteMarcaResponseDto {

    private Integer id;
    private String patente;
    private String marca;

}
