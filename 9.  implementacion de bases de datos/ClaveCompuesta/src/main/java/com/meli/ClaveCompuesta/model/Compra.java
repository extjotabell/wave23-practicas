package com.meli.ClaveCompuesta.model;

import com.meli.ClaveCompuesta.model.key.CompraKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(CompraKey.class)
public class Compra {

    @Id
    private Long idProducto;

    @Id
    private Long idCliente;

    private int cantidad;

}
