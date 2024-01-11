package com.example.ejercicioClaveCompuesta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraKey implements Serializable {
    private Long clienteId;
    private Date fecha;
}
