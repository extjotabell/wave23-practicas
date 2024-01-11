package com.example.ejercicioClaveCompuesta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewCompraRequestDto {
    private Long clienteId;
    private Date fecha;
    private String sucursal;
}
