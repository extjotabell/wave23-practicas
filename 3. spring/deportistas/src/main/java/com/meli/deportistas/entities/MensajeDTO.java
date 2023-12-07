package com.meli.deportistas.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MensajeDTO implements Serializable {
    private String mensaje;

    public MensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }
}
